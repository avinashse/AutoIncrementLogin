package com.app.api.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import org.springframework.data.mongodb.core.query.Update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.stereotype.Service;

import com.app.api.model.CustomSequences;

@Service
public class NextSequencesService {
	@Autowired private MongoOperations mongo;

	@Autowired
    public NextSequencesService(MongoOperations mongo) {
        this.mongo = mongo;
    }
	
    public long getNextSequence(String seqName)
    {
    	System.out.println("seqName : " + seqName);
		Query query = new Query();
    	query.addCriteria(Criteria.where("_id").is(seqName));
    	CustomSequences counter = mongo.findAndModify(
              query,new Update().inc("seq",1),
              options().returnNew(true).upsert(true),
              CustomSequences.class);

//    	List<CustomSequences> counter =  mongo.find(query(where("_id").is(seqName)), CustomSequences.class);
//    	List<CustomSequences> counter = mongo.findAll(CustomSequences.class);
//    	CustomSequences  counter = mongo.findOne(query, CustomSequences.class);
    	try
    	{
    		System.out.println("counter.getSeq() : " + counter.getSeq());
    	}
    	catch(Exception e)
    	{
    		System.out.println("Exception " + e);
    	}
    	return counter.getSeq();
    }
}
