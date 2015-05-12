/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.math;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * Immutable, arbitrary-precision signed decimal numbers. 
 * A BigDecimal consists of an arbitrary precision integer unscaled value and a 32-bit integer scale. 
 * If zero or positive, the scale is the number of digits to the right of the decimal point. 
 * If negative, the unscaled value of the number is multiplied by ten to the power of the negation of the scale. 
 * The value of the number represented by the BigDecimal is therefore (unscaledValue × 10-scale). 
 * 
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年5月11日 下午4:37:43
 * <p>Version: 1.0
 */
public class BigDecimalTest {
	
	
	@Test
	public void test(){
		BigDecimal nd=new BigDecimal(1);
		//-1, 0, or 1 as this BigDecimal is numerically less than, equal to, or greater than val.
		nd.compareTo(BigDecimal.ZERO);
	}

}
