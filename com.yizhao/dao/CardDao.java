/**
* @Description:手动实现第一个CardDao的编写
* @Param:
* @return:
* @Author: Mr.Yooda
* @Date: 2018/3/5
*/
import com.yizhao.model.Card;
import java.sql.*;
import java.util.*;

public class CardDao{
    public CardDao(){}

    public void insert(Card stu){
        //创建一个数据连接的对象
        Connection con = null;
        //创建一个执行命令的对象
        PreparedStatement ps = null;
        try {
            /** 数据库操作系列代码*/

            //调用ConnectionManager的静态方法,建立数据库连接.
            con = ConnectionManager.getConnection();

            //数据库操作的SQL语句
            String sq = "insert into Card (Id,MemberId,password,balance)" +
                    "       values (?,?,?,?)";
            //建立一个PreparedStatement对象执行SQL语句。
            ps = con.prepareStatement(sq);

            //设置命令参数.
            ps.setString(1,stu.getId());
            ps.setString(2,stu.getMemberId());
            ps.setString(3, stu.getPassword());
            ps.setDouble(4,stu.getBalance());

            //执行SQL语句
            ps.executeUpdate();

            System.out.println("添加信息完成了!");

        } catch (Exception e) {
            System.out.println("CardDAO类的insert()方法有错误! : "
                    + e.getMessage());
        } finally {

            /** 释放资源系列代码*/
            ConnectionManager.StatementClose(ps); //释放执行命令的对象
            ConnectionManager.ConnectionClose(con); //关闭数据库连接
        }
    }
    /**
     * 根据主键删除求职者信息的方法.
     * 参数是: 你要删除的那个求职者
     */
    public void delete(Card stu) {

        //声明一个数据库连接对象
        Connection con = null;
        //声明一个执行命令的对象
        PreparedStatement ps = null;

        try {
            /** 数据库操作系列代码*/

            //调用ConnectionManager的静态方法,建立数据库连接.
            con = ConnectionManager.getConnection();

            //数据库操作的SQL语句
            String sq = "delete from Card " +
                    " where Id=?";

            //建立一个PreparedStatement对象执行SQL语句。
            ps = con.prepareStatement(sq);

            //设置命令参数.
            ps.setString(1, stu.getId());

            //执行SQL语句
            ps.executeUpdate();

            System.out.println("删除信息完成了!");

        } catch (Exception e) {
            System.out.println("CardDAO类的delete()方法有错误! : "
                    + e.getMessage());
        } finally {

            /** 释放资源系列代码*/
            ConnectionManager.StatementClose(ps); //释放执行命令的对象
            ConnectionManager.ConnectionClose(con); //关闭数据库连接
        }
    }
}



