package ru.magnit.test.vacancy.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.magnit.test.vacancy.model.ContactData;
import ru.magnit.test.vacancy.model.Contacts;



import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by Fedor on 17.10.2016.
 */
public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if(app.contact().all().size() == 0) {
      app.contact().create(new ContactData().
              withFirstName("test1").withLastName("test2").withAddress("test3").withCompany("test4").withAddress("test5").
              withMiddleName("test6").withNickName("test7").withTitle("test8").withHome("123456").withMobile("89876543210"));
    }
  }


  @Test(enabled = true)
  public void testContactModification() {
    Contacts before = app.contact().all();

    ContactData modifyContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifyContact.getId()).
            withFirstName("test1111").withMiddleName("test30").withLastName("test2222").withNickName("test40").
            withCompany("test50").withTitle("test60").withAddress("test70").withHome("1234560").withMobile("898765432100");

    app.contact().modify(contact);
    assertEquals(app.contact().count(), before.size());
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(modifyContact).withAdded(contact)));


  }


}
