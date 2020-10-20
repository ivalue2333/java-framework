package com.iota.core.design_pattern._08_filter_pattern;

import java.util.List;
 
public class AndCriteria implements Criteria {
 
   private Criteria criteria;
   private Criteria otherCriteria;
 
   public AndCriteria(Criteria criteria, Criteria otherCriteria) {
      this.criteria = criteria;
      this.otherCriteria = otherCriteria; 
   }
 
//  这个是我之前很想要的一个东西，一个过滤器的输出可以作为下一个过滤器的输入
//  这个确实也是基本规范了
//  关键就是函数参数类型和返回类型相同
   @Override
   public List<Person> meetCriteria(List<Person> persons) {
      List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);     
      return otherCriteria.meetCriteria(firstCriteriaPersons);
   }
}