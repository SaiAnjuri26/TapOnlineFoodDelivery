package com.samfoods.DaoImpl;

import com.samfoods.Dao.MenuDao;



import com.samfoods.DbUtills.DButills;
import com.samfoods.model.Menu;

import java.sql.*;
import java.util.ArrayList;
public class MenuDaoImpl implements MenuDao
{

	private Connection con;
    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet resultSet;
    private ArrayList<Menu> menuList = new ArrayList<>();
    

    private static final String ADD_MENU = "INSERT INTO menu (restuarantId, menuName, price, description, isAvaliable, imagePath) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM menutable";
    private static final String SELECT_ON_NAME = "SELECT * FROM menu WHERE menuName = ?";
    private static final String UPDATE_ON_ID = "UPDATE menutable SET restuarantId = ?, menuName = ?, price = ?, description = ?, isAvaliable = ?, imagePath = ? WHERE menuId = ?";
    private static final String DELETE_ON_NAME = "DELETE FROM menutable WHERE menuName = ?";
    
    
    private static final String SELECT_ON_RESID = "SELECT * FROM `menu` WHERE  restaurantId=?";
    private static final String SELECT_ON_MENUID = "SELECT * FROM `menu` WHERE  menuId=?";
    

    public MenuDaoImpl() {
        try {
            con = DButills.myConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
	
	
	
	@Override
	public int addMenu(Menu m) {
		int status = 0;
        try {
            pstmt = con.prepareStatement(ADD_MENU);
            pstmt.setInt(1, m.getRestaurantId());
            pstmt.setString(2, m.getMenuName());
            pstmt.setDouble(3, m.getPrice());
            pstmt.setString(4, m.getDescription());
            pstmt.setString(5, m.getisAvaliable());
            pstmt.setString(6, m.getImagePath());

            status = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
	}

	@Override
	public void getAllMenu() {
		try {
            stmt = con.createStatement();
            resultSet = stmt.executeQuery(SELECT_ALL);
            menuList = extractMenuFromResultSet(resultSet);

            // Optionally print all menus
            for (Menu menu : menuList) {
                System.out.println(menu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	@Override
	public ArrayList<Menu> getSpecificMenu(int menuId) {
		ArrayList<Menu> specificMenuList = new ArrayList<>();
        try {
            pstmt = con.prepareStatement(SELECT_ON_MENUID);
            pstmt.setInt(1, menuId);

            resultSet = pstmt.executeQuery();
            specificMenuList = extractMenuFromResultSet(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return specificMenuList;
	}

	@Override
	public int updateMenuIteam(Menu m) {
		int status = 0;
        try {
            pstmt = con.prepareStatement(UPDATE_ON_ID);
            pstmt.setInt(1, m.getRestaurantId());
            pstmt.setString(2, m.getMenuName());
            pstmt.setDouble(3, m.getPrice());
            pstmt.setString(4, m.getDescription());
            pstmt.setString(5, m.getisAvaliable());
            pstmt.setString(6, m.getImagePath());
            pstmt.setInt(7, m.getMenuId());

            status = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
	}

	@Override
	public int deleteMenuIteam(String menuName) {
		int status = 0;
        try {
            pstmt = con.prepareStatement(DELETE_ON_NAME);
            pstmt.setString(1, menuName);

            status = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
	}
	private ArrayList<Menu> extractMenuFromResultSet(ResultSet resultSet) {
        ArrayList<Menu> menus = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Menu menu = new Menu(
                    resultSet.getInt("menuId"),
                    resultSet.getInt("restaurantId"),
                    resultSet.getString("menuName"),
                    resultSet.getFloat("price"),
                    resultSet.getString("description"),
                    resultSet.getString("isAvaliable"),
                    resultSet.getString("imagePath")
                );
                menus.add(menu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menus;
    }





	@Override
	public ArrayList<Menu> getMenuOnRestaurantId(int restaurantId) {
		ArrayList<Menu> Menulist = new ArrayList<>();
        try {
            pstmt = con.prepareStatement(SELECT_ON_RESID);
            pstmt.setInt(1, restaurantId);

            resultSet = pstmt.executeQuery();
            Menulist = extractMenuFromResultSet(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Menulist;
		
	}
	private ArrayList<Menu> extractMenuFromResultSet1(ResultSet resultSet) {
        ArrayList<Menu> menus = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Menu menuList = new Menu(
                    resultSet.getInt("menuId"),
                    resultSet.getInt("restaurantId"),
                    resultSet.getString("menuName"),
                    resultSet.getFloat("price"),
                    resultSet.getString("description"),
                    resultSet.getString("isAvaliable"),
                    resultSet.getString("imagePath")
                );
                
                menus.add(menuList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menus;
    }

}
