package ru.magnit.test.vacancy.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Fedor on 11.03.2017.
 */
public class Vacancies  extends ForwardingSet<VacancyData> {

  private Set<VacancyData> delegate;

  public Vacancies(Vacancies vacancies) {
    this.delegate = new HashSet<VacancyData>(vacancies.delegate);
  }

  public Vacancies() {
    this.delegate = new HashSet<VacancyData>();
  }

  @Override
  protected Set<VacancyData> delegate() {
    return delegate;
  }

}

