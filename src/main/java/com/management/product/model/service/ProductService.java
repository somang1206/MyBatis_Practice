package com.management.product.model.service;

import com.common.SearchCondition;
import com.management.product.model.dao.ProductDAO;
import com.management.product.model.dto.ProductDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.common.Template.getSqlSession;

public class ProductService {

    // * 주석을 지우고 Service 역할에 해당하는 메소드를 작성하세요.

    // 1. 자주 사용할 DAO 객체를 선언s하세요.
    private ProductDAO productDAO;

    public List<ProductDTO> selectAllProductList() {

        // 2. 전체 제품 목록을 조회하는 로직을 작성하세요.
        // 　　아래 작성된 return null은 과제 툴 오류를 제거하고자 임의 작성하였으니 지우고 로직을 작성하세요.

        SqlSession sqlSession = getSqlSession();

        productDAO = sqlSession.getMapper(ProductDAO.class);
        List<ProductDTO> menuList = productDAO.selectAllProductList();

        sqlSession.close();

        return menuList;

    }

    public List<ProductDTO> selectProductByCondition(SearchCondition searchCondition) {

        // 3. 조건에 따른 제품 목록을 조회하는 로직을 작성하세요.
        // 　　아래 작성된 return null은 과제 툴 오류를 제거하고자 임의 작성하였으니 지우고 로직을 작성하세요.

        SqlSession sqlSession = getSqlSession();

        productDAO = sqlSession.getMapper(ProductDAO.class);
        List<ProductDTO> menuList = productDAO.selectProductByCondition(searchCondition);

        sqlSession.close();
        return menuList;

    }

    public boolean registNewProduct(ProductDTO product) {

        // 4. 제품 정보를 등록하는 로직을 작성하세요.
        // 　　아래 작성된 return false 과제 툴 오류를 제거하고자 임의 작성하였으니 지우고 로직을 작성하세요.

        SqlSession sqlSession = getSqlSession();

        productDAO = sqlSession.getMapper(ProductDAO.class);

        int result = productDAO.insertProduct(product);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;

    }

    public boolean modifyProductInfo(ProductDTO product) {


        SqlSession sqlSession = getSqlSession();

        productDAO = sqlSession.getMapper(ProductDAO.class);
        int result = productDAO.updateProduct(product);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();


        return result > 0 ? true : false;
    }

    public boolean deleteProduct(Map<String, String> parameter) {


        SqlSession sqlSession = getSqlSession();

        productDAO = sqlSession.getMapper(ProductDAO.class);

        int result = productDAO.deleteProduct(parameter);

        if( result > 0) {
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;

    }


}