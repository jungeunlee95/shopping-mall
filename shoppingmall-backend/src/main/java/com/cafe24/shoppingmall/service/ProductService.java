package com.cafe24.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.shoppingmall.repository.ProductDao;
import com.cafe24.shoppingmall.vo.OptionNameVo;
import com.cafe24.shoppingmall.vo.OptionValueVo;
import com.cafe24.shoppingmall.vo.OptionVo;
import com.cafe24.shoppingmall.vo.ProductVo;

@Transactional(rollbackFor = Exception.class)
@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	/**
	 * 상품 리스트 가져오기 (카테고리 or 키워드)
	 * @param categodyNo
	 * @param keyword
	 * @return
	 */
	public List<ProductVo> getProductList(Long categoryNo, String keyword) {
		List<ProductVo> list = productDao.getList(categoryNo, keyword);
		return list;
	}

	/**
	 * 메인 상품 리스트
	 * @return
	 */
	public List<ProductVo> getProductList() {
		List<ProductVo> list = productDao.getList();
		return list;
	}

	/** 
	 * 장바구니에 담긴 상품 리스트
	 * @param userId
	 * @return
	 */
	public List<ProductVo> getProductList(String userId) {
		List<ProductVo> list = productDao.getList(userId);
		return list;
	}

	/**
	 * 상품 등록
	 * @param productVo
	 * @return
	 */
	public Boolean addProduct(ProductVo productVo) {
		// 트랜잭션 적용하면 사라질 코드
		int result = 0;  // 상품등록 성공 확인
		int result2 = 0; // 카테고리 등록 성공 확인
		int result3 = 0; // 옵션 등록 성공 확인
		int result4 = 0; // 옵션 등록 성공 확인
 
		// 옵션 사용 X -> 카테고리만 등록
		result = productDao.addProduct(productVo);
		
		if(result==1) {
			result4 =productDao.addMainImage(productVo);
		}
		
		if(result==1) {
			result2 =productDao.addCategoryAndProduct(productVo.getNo(), productVo.getCategoryList());
		}
		
		// 옵션 사용 O -> 옵션 등록
		if(result==1 && productVo.getIsOption()){
//			result3 = productDao.addOptionValue(productVo.getNo(), productVo.getOptionValueList());
			result3 = productDao.addProductOption(productVo.getNo(), productVo.getOptionNameList());
		}
		
		return result==1 && result2==productVo.getCategoryList().size(); 
	} 

	public OptionVo addOption(OptionVo optionVo) {
		// 옵션 이름이 이미 테이블에 존재하는지 검사
		List<OptionVo> optionList = productDao.getOption(optionVo.getName());
		if(optionList.size()<1) {
			productDao.addOption(optionVo);
			return optionVo;
		}
		return optionList.get(0);
	}

	public ProductVo getProductDetail(Long productNo) {
		return productDao.getProductDetail(productNo);
	}

	public Boolean deleteProduct(Long no) {
		Boolean result = productDao.delete(no)==1;
		return result;
	}

	public ProductVo modifyProduct(ProductVo productVo) {
		productDao.modify(productVo);
		ProductVo vo = productDao.getProductDetail(productVo.getNo());
		return vo;
	}

	public boolean addProductOption(List<OptionNameVo> optionNameVoList) {
		productDao.deleteOption(optionNameVoList.get(0).getProductNo());
		return productDao.addProductOption(optionNameVoList)==optionNameVoList.size();
	}

	public List<OptionValueVo> getLowOption(Long productNo) {
		List<OptionValueVo> optionValueVoList = productDao.getLowOption(productNo);
		return optionValueVoList;
	}

	public boolean modifyOptionValue(Long productNo, List<OptionValueVo> optionValueVoList) {
		int result = productDao.deleteOptionValue(productNo);
		int result2 = productDao.addOptionValue(productNo, optionValueVoList);
		return result2 == optionValueVoList.size();
	}

	public List<OptionNameVo> getOptionList(Long no) {
		List<OptionNameVo> result = productDao.getOptionList(no);
		return result;
	}
}











