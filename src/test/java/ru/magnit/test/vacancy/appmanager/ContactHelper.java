package ru.magnit.test.vacancy.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.magnit.test.vacancy.model.ContactData;
import ru.magnit.test.vacancy.model.Contacts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fedor on 16.10.2016.
 */
public class ContactHelper extends HelperBase {

  private Contacts contactCash = null;

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void returnHomePage() {
    click(By.linkText("home page"));
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void fillContactInfo(ContactData contactData) {

    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickName());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHome());
    type(By.name("mobile"), contactData.getMobile());
    attach(By.name("photo"), contactData.getPhoto());

  }


  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));

  }

  public void confirmDeletion() {
    wd.switchTo().alert().accept();
  }

  public void delete(ContactData deleteContact) throws InterruptedException {
    selectContactById(deleteContact);
    deleteContact();
    confirmDeletion();
    contactCash = null;
    Thread.sleep(2000);
  }

  public void selectContact(int index) {
    WebElement element = wd.findElements(By.name("selected[]")).get(index);
    if (!element.isSelected()) {
      element.click();
    }

  }

  public void selectContactById(ContactData contact) {
    WebElement element = wd.findElement(By.cssSelector("input[id = '" + contact.getId() + "']"));
    if (!element.isSelected()) {
      element.click();
    }

  }


  public void initModification(ContactData contactData) {
    wd.findElement(By.xpath("//tr/td/input[@id = '" + contactData.getId()+ "']/../../td[8]/a")).click();
  }

  public void modify(ContactData contact) {
    initModification(contact);
    fillContactInfo(contact);
    submitContactUpdate();
    contactCash = null;
    returnHomePage();
  }

  public void submitContactUpdate() {
    click(By.name("update"));
  }

  public void create(ContactData contact) {
    initContactCreation();
    fillContactInfo(contact);
    submitContactCreation();
    contactCash = null;
    returnHomePage();
  }


  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> rows = wd.findElements(By.cssSelector("tr"));
    rows.remove(0);
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.cssSelector("td"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String address = cells.get(3).getText();
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData().withId(id).withFirstName(firstname).withLastName(lastname).withAddress(address);
      contacts.add(contact);
    }
    return contacts;
  }

  public Contacts all() {
    if (contactCash != null){
      return new Contacts(contactCash);
    }
    contactCash = new Contacts();
    List<WebElement> rows = wd.findElements(By.cssSelector("table[id = 'maintable']>tbody>tr"));
    rows.remove(0);
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.cssSelector("td"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String address = cells.get(3).getText();
      String allPhones = cells.get(5).getText();
      String email = cells.get(4).getText();
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      contactCash.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname).withAddress(address)
              .withAllPhones(allPhones).withEmail(email));

    }
    return new Contacts(contactCash);
  }
  public ContactData infoFromEditForm(ContactData contact){
    initModification(contact);
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String middlename = wd.findElement(By.name("middlename")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String nickname = wd.findElement(By.name("nickname")).getAttribute("value");
    String company = wd.findElement(By.name("company")).getAttribute("value");
    String title = wd.findElement(By.name("title")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String fax = wd.findElement(By.name("fax")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String homepage = wd.findElement(By.name("homepage")).getAttribute("value");
    String address2 = wd.findElement(By.name("address2")).getAttribute("value");
    String phone2 = wd.findElement(By.name("phone2")).getAttribute("value");
    String notes = wd.findElement(By.name("notes")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withHome(home).withMobile(mobile).withWork(work)
            .withFirstName(firstname).withLastName(lastname).withMiddleName(middlename).
            withEmail(email).withAddress(address).withNickName(nickname).withCompany(company)
            .withTitle(title).withFax(fax).withEmail2(email2).withEmail3(email3)
            .withHomepage(homepage).withAddress2(address2).withPhone2(phone2).withNotes(notes);
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }


  public void goToSummery(ContactData contact) {
    wd.findElement(By.xpath(String.format("//tr/td/input[@id = '%s']/../../td[7]/a",contact.getId()))).click();
  }

  public String getAllInfo() {
    return wd.findElement(By.id("content")).getText();
  }
}
