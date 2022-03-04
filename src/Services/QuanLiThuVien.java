/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import ConnectSQLSV.ConnectSQL;
import Model.Bao;
import Model.Sach;
import Model.TapChi;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author pc
 */
public class QuanLiThuVien {
    public List<Sach> getAllBooks() throws SQLException{
        List<Sach> books = new ArrayList<Sach>();
        Connection con = ConnectSQL.getConnectSQL();
        
        String sql = "Select * From Sach";
        
        try{
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {
                Sach sach = new Sach();
                
                sach.setMaSach(rs.getString("maSach"));
                sach.setTenNXB(rs.getString("tenNXB"));
                sach.setSoBanPhatHanh(rs.getInt("soBanPhatHanh"));
                sach.setTenTacGia(rs.getString("tenTacGia"));
                sach.setSoTrang(rs.getInt("soTrang"));
                
                books.add(sach);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return books;
    }
    public List<TapChi> getAllJournal() throws SQLException{
        List<TapChi> journals = new ArrayList<TapChi>();
        Connection con = ConnectSQL.getConnectSQL();
        
        String sql = "Select * from TapChi";
        
        try{
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {
                TapChi tapchi = new TapChi();
                
                tapchi.setMaTapChi(rs.getString("maTapChi"));
                tapchi.setTenNXB(rs.getString("tenNXB"));
                tapchi.setSoBanPhatHanh(rs.getInt("soBanPhatHanh"));
                tapchi.setSoPhatHanh(rs.getInt("soPhatHanh"));
                tapchi.setThangPhatHanh(rs.getInt("thangPhatHanh"));
                
                journals.add(tapchi);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return journals;
    }
    
    public List<Bao> getAllMagazines() throws SQLException{
        List<Bao> magazines = new ArrayList<Bao>();
        Connection con = ConnectSQL.getConnectSQL();
        
        String sql = "Select * from Bao";
               
        try{
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
                Bao bao = new Bao();
                
                bao.setMaBao(rs.getString("maBao"));
                bao.setTenNXB(rs.getString("tenNXB"));
                bao.setSoBanPhatHanh(rs.getInt("soBanPhatHanh"));
                bao.setNgayPhatHanh(rs.getString("ngayPhatHanh"));
                
                magazines.add(bao);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return magazines;
    }
    
    public void AddBook(Sach sach){
        Connection con = ConnectSQL.getConnectSQL();
        
        String sql = "Insert into Sach(maSach, tenNXB, soBanPhatHanh, tenTacGia, soTrang)"
                + "Values (?,?,?,?,?)";
        
        try{
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, sach.getMaSach());
            preparedStatement.setString(2, sach.getTenNXB());
            preparedStatement.setInt(3, sach.getSoBanPhatHanh());
            preparedStatement.setString(4, sach.getTenTacGia());
            preparedStatement.setInt(5, sach.getSoTrang());
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void AddJournal(TapChi tapchi){
        Connection con = ConnectSQL.getConnectSQL();
        String sql = "Insert into TapChi(maTapChi,tenNXB,soBanPhatHanh,soPhatHanh,ThangPhatHanh)"
                + "Values(?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, tapchi.getMaTapChi());
            preparedStatement.setString(2, tapchi.getTenNXB());
            preparedStatement.setInt(3, tapchi.getSoBanPhatHanh());
            preparedStatement.setInt(4, tapchi.getSoPhatHanh());
            preparedStatement.setInt(5, tapchi.getThangPhatHanh());
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void AddMagazines(Bao bao){
        Connection con = ConnectSQL.getConnectSQL();
        String sql = "Insert into Bao(maBao,tenNXB,soBanPhatHanh,NgayPhatHanh)"
                + "Values(?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, bao.getMaBao());
            preparedStatement.setString(2, bao.getTenNXB());
            preparedStatement.setInt(3, bao.getSoBanPhatHanh());
            preparedStatement.setString(4, bao.getNgayPhatHanh());
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
