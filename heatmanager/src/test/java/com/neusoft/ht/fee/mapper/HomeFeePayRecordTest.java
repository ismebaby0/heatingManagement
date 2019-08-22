package com.neusoft.ht.fee.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.neusoft.ht.fee.model.HomeFeePayRecord;
import com.neusoft.ht.fee.model.PaymentType;;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeFeePayRecordTest {
	@Autowired
	private IHomeFeePayRecordMapper homeFeePayRecordMapper;
	@Autowired
	private com.neusoft.ht.fee.mapper.IPaymentTypeMapper paymentType;
	@Autowired
	private com.neusoft.ht.fee.mapper.IHomeFeeMapper homefee;
	
	
	@Test
	public void selectByAll() throws Exception {
		homeFeePayRecordMapper.selectByAll().forEach(e->{System.out.print(e.getPaymentTypeNo()+"\n"+e.getHomeFeeNo());});
		System.out.println();
		System.out.println(homeFeePayRecordMapper.selectTotalCount());
	}
	
	@Test
	public void insert() throws Exception {
//		homeFeePayRecordMapper.selectByAll().forEach(e->{System.out.print(e.getRecordNo()+",");});
		HomeFeePayRecord homeFeePayRecord = new HomeFeePayRecord();
		homeFeePayRecord.setPaymentTypeNo(paymentType.selectByPrimaryKey(2));
		homeFeePayRecord.setHomeFeeNo(homefee.getByPrimaryKey(5));
		homeFeePayRecordMapper.insert(homeFeePayRecord);
		System.out.println(homeFeePayRecordMapper.selectTotalCount());
	}

	@Test
	public void update() throws Exception{
		HomeFeePayRecord homeFeePayRecord = homeFeePayRecordMapper.selectByPrimaryKey(2);
		homeFeePayRecord.setPayPerson("lz");
		homeFeePayRecordMapper.updateByPrimaryKey(homeFeePayRecord);
	}
	
}