package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public static int login(String name, String pwd){
        int state=0;
        String sql = "select * FROM USER where username='"+name+"' and userpwd='"+pwd+"';";
        try{
            ResultSet rs = DA.execSql(sql);
            if(rs.next())
                state=1;
        }  catch (SQLException e) {
                e.printStackTrace();
        }
        return state;
    }
    public static int updateLastTime(String name,String date){
        int state=0;
        String sql = "update USER SET lateLoginDate='"+date+"' where username='"+name+"';";
            int rs = DA.execUpdate(sql);
            if(rs>0)
                state=1;
        return state;
    }
    public static int findUser(String name){
        String sql="select * FROM USER where username='"+name+"';";
        int state = 0;
        try{
            ResultSet rs = DA.execSql(sql);
            if(rs.next())
                state=1;
        }  catch (SQLException e) {
            e.printStackTrace();
        }
        return state;
    }
    public static int addUser(String name,String pwd,String date,String email,String qq){
        int state = 0;
        String date2 = " ";
        String sql = "INSERT INTO USER VALUES ('"+name+"','"+pwd+"', '"+date+"', '"+date2+"',0,'"+email+"','"+qq+"');";
        int rs = DA.execUpdate(sql);
        if(rs>0)
            state=1;
        return state;
    }
    public static int editInfo(String name ,String email,String qq,String nickname){
        int state=0;
        String sql = "update USER SET email='"+email+"',qq='"+ qq +"',nickname='"+ nickname+"' where username='"+name+"';";
        int rs = DA.execUpdate(sql);
        if(rs>0)
            state=1;
        return state;
    }
    public static int editPwd(String name ,String newPwd){
        int state=0;
        String sql = "update USER SET userpwd='"+newPwd+"' where username='"+name+"';";
        int rs = DA.execUpdate(sql);
        if(rs>0)
            state=1;
        return state;
    }
}
