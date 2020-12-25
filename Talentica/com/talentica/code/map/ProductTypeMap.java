package com.talentica.code.map;

import java.util.HashMap;
import java.util.Map;

import com.talentica.code.enums.ProductTypeEnum;

public class ProductTypeMap {
	
	public static final Map<String,ProductTypeEnum> productTypeMap;

	static {
		Map<String,ProductTypeEnum> productTypeTempMap = new HashMap<>();
		productTypeTempMap.put("soap", ProductTypeEnum.OTHERS);
		productTypeTempMap.put("potato", ProductTypeEnum.FOOD);
		productTypeTempMap.put("music", ProductTypeEnum.OTHERS);
		productTypeTempMap.put("perfume", ProductTypeEnum.OTHERS);
		productTypeTempMap.put("crocin", ProductTypeEnum.MEDICINE);
		productTypeTempMap.put("handbag", ProductTypeEnum.OTHERS);
		productTypeTempMap.put("sunglasses", ProductTypeEnum.OTHERS);
		productTypeTempMap.put("chocolates", ProductTypeEnum.FOOD);
		productTypeTempMap.put("Teddy bear", ProductTypeEnum.FOOD);
		productTypeMap = productTypeTempMap;
	}

}
