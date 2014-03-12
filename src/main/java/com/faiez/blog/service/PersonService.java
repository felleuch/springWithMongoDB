package com.faiez.blog.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.faiez.blog.model.Person;

@Repository
public class PersonService {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public static final String COLLECTION_NAME = "person";
	
	public void addPerson(Person person) {
		if (!mongoTemplate.collectionExists(Person.class)) {
			mongoTemplate.createCollection(Person.class);
		}		
		person.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(person, COLLECTION_NAME);
	}
	
	public List<Person> listPerson() {
		return mongoTemplate.findAll(Person.class, COLLECTION_NAME);
	}

	public List<Person> findByNameAndAge() {

		Query query2 = new Query();
		query2.addCriteria(Criteria.where("name").is("ahmed").and("age").is(18));

		return mongoTemplate.find(query2, Person.class);


	}


	
	public void deletePerson(Person person) {
		mongoTemplate.remove(person, COLLECTION_NAME);
	}
	
	public void updatePerson(Person person) {
		mongoTemplate.insert(person, COLLECTION_NAME);		
	}


}

/*
		List<Integer> listOfAge = new ArrayList<Integer>();
		listOfAge.add(10);
		listOfAge.add(30);
		listOfAge.add(40);

		Query query3 = new Query();
		query3.addCriteria(Criteria.where("age").in(listOfAge));

		List<User> userTest3 = mongoOperation.find(query3, User.class);

		Query query4 = new Query();

		query4.addCriteria(
		Criteria.where("age").exists(true).andOperator(
		Criteria.where("age").gt(10),
		Criteria.where("age").lt(40)
		)
		);

		List<User> userTest4 = mongoOperation.find(query4, User.class);


		Query query5 = new Query();
		query5.addCriteria(Criteria.where("age").gte(30));
		query5.with(new Sort(Sort.Direction.DESC, "age"));

		List<User> userTest5 = mongoOperation.find(query5, User.class);

		Query query6 = new Query();
		query6.addCriteria(Criteria.where("name").regex("D.*G", "i"));

		List<User> userTest6 = mongoOperation.find(query6, User.class);



		mongoOperation.dropCollection(User.class);

		*/
