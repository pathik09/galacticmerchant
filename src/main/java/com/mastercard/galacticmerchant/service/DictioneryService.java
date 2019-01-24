package com.mastercard.galacticmerchant.service;



import java.util.List;
import java.util.Optional;

import com.mastercard.galacticmerchant.model.Dictionery;


/**
 * @author acer
 *
 */
public interface DictioneryService {

   

    /**
     * @param id
     * @return
     * THis method will retrieve the single dictionery for the 
     * corresponding id from h2 database.
     */
    Optional<Dictionery> getDictionery(Long id);

    /**
     * @param dictionery
     * @return
     * This method will edit the dictionery object in h2 database.
     */
    Dictionery editDictionery(Dictionery dictionery);

    /**
     * @param dictionery
     * This method will delete the particular dictionery object.
     */
    void deleteDictionery(Dictionery dictionery);

    /**
     * @param id
     * THis method is used to delete dictionery for the mentioned id.
     */
    void deleteDictionery(Long id);
    
    /**
     * @param romanNumeral
     * @return
     * THis is specialized method created for finding using romanNumeral.
     */
    List<Dictionery> findByRomanNumeral(String romanNumeral);
    
    /**
     * @param galaticQuantity
     * @return
     *  THis is specialized method created for finding using galaticQuantity.
     */
    List<Dictionery> findByGalacticQuantity(String galaticQuantity);

   

    long countDictionerys();

	Dictionery createDictionery(Dictionery dictionery_model);
	
	
}
