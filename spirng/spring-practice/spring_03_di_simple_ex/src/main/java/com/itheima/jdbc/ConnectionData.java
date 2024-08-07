package com.itheima.jdbc;

public class ConnectionData {

    private String driverClassName = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306?spring_db?serverTimezone=UTC";
    private String userName = "root";
    private String password = "root";

    @Override
    public String toString() {
        return "连接数据：" +
                "\ndriverClassName = " + driverClassName +
                "\nurl = " + url +
                "\nuserName = " + userName +
                "\npassword = " + password ;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
