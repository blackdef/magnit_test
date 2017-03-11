package ru.magnit.test.vacancy.model;

import java.io.File;
/**
 * Created by Fedor on 09.03.2017.
 */
public class VacancyData {

  private String region;
  private String city;
  private String vacancyName;
  private String personFullName;
  private String birthDay;
  private String birthYear;
  private String contactPhone;
  private String email;
  private Boolean approval;
  private File resume;
  private Integer regionId;
  private Integer cityId;
  private Integer vacancyNameId;

  public Integer getRegionId() {
    return regionId;
  }

  public Integer getCityId() {
    return cityId;
  }

  public Integer getVacancyNameId() {
    return vacancyNameId;
  }

  public String getRegion() {
    return region;
  }

  public String getCity() {
    return city;
  }

  public String getVacancyName() {
    return vacancyName;
  }

  public String getPersonFullName() {
    return personFullName;
  }

  public String getBirthDay() {
    return birthDay;
  }

  public String getBirthYear() {
    return birthYear;
  }

  public String getContactPhone() {
    return contactPhone;
  }

  public String getEmail() {
    return email;
  }

  public Boolean getApproval() {
    return approval;
  }

  public File getResume() {
    return resume;
  }

  public VacancyData withRegion(String region) {
    this.region = region;
    return this;
  }

  public VacancyData withRegionId(Integer regionId) {
    this.regionId = regionId;
    return this;
  }

  public VacancyData withCityId(Integer cityId) {
    this.cityId = cityId;
    return this;
  }

  public VacancyData withVacancyNameId(Integer vacancyNameId) {
    this.vacancyNameId = vacancyNameId;
    return this;
  }

  public VacancyData withCity(String city) {
    this.city = city;
    return this;
  }

  public VacancyData withVacancyName(String vacancyName) {
    this.vacancyName = vacancyName;
    return this;
  }

  public VacancyData withPersoneFullName(String personeFullName) {
    this.personFullName = personeFullName;
    return this;
  }

  public VacancyData withBirthDay(String birthDay) {
    this.birthDay = birthDay;
    return this;
  }

  public VacancyData withBirthYear(String birthYear) {
    this.birthYear = birthYear;
    return this;
  }

  public VacancyData withContactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
    return this;
  }

  public VacancyData withEmail(String email) {
    this.email = email;
    return this;
  }

  public VacancyData withApproval(Boolean approval) {
    this.approval = approval;
    return this;
  }

  public VacancyData withResume(File resume) {
    this.resume = resume;
    return this;
  }



}
