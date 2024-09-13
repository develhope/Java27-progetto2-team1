package Utility;

import Products.ProdottoElettronico;
import Products.ProdottoElettronicoUtente;

public class ProductMapper {

	public static <T,U> U convertTo(T source, U target){
		if(source instanceof ProdottoElettronico prd && target instanceof ProdottoElettronicoUtente userPrd){
            userPrd.setMarca(prd.getMarca());
			userPrd.setModello(prd.getModello());
			userPrd.setDescrizione(prd.getDescrizione());
			userPrd.setPrezzoVendita(prd.getPrezzoVendita());
			userPrd.setId(prd.getId());
			userPrd.setTipoElettronico(prd.getTipoElettronico());
			userPrd.setDimSchermo(prd.getDimSchermo());
			return target;
		}else if( source instanceof ProdottoElettronicoUtente userPrd && target instanceof ProdottoElettronico prd){
            prd.setMarca(userPrd.getMarca());
			prd.setModello(userPrd.getModello());
			prd.setDescrizione(userPrd.getDescrizione());
			prd.setPrezzoVendita(userPrd.getPrezzoVendita());
			prd.setId(userPrd.getId());
			prd.setQuantitaMagazzino(userPrd.getQuantitaCarrello());
			prd.setTipoElettronico(userPrd.getTipoElettronico());
			prd.setDimSchermo(userPrd.getDimSchermo());
			return target;
		} else {
			throw new IllegalArgumentException("Conversione non avvenuta con successo");
		}

	}


}
