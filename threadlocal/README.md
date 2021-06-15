1.      采用osiv模式 Open Session In View,session在英文中是会话的意思
        在filter中写有关事务的管理，osiv和aop都是有关事务的管理模式

2.      c3p0的工具类需要和ThreadLocal结合一下,把getConn的方法重写
        //先从threadLocal中读取数据
        Connection conn = threadLocal.get();    。。。

3.      最后不要忘记关闭,还要将链接从ThreadLocal中删除
        java.sql.SQLException: You can't operate on a closed Connection!!!
        这就是没有将conn从从ThreadLocal中删除引起的，需要写一个remove，参考UserFilter，中finally部分
        c3p0封装conn的时候，采用的是包装的方式，每次拿的conn都是包装过的，地址都是不同的
        使用了ThreadLocal后，当conn.close();就会将conn重新放入pool中，但这个conn的地址和以前使用的不同
        而Connection conn = C3p0Utils.getConnection();在拿的话，因为使用的还是同一个线程
        filter thread name is : http-8080-1     ,所以得到的是一个已经没有了的conn
        所以要用ThreadLocal.remove();将那个conn删掉

        当然，就算是c3p0封装conn的时候，得到的conn是相同的话，也要写ThreadLocal.renove()，因为
        当你用完一次链接close的时候，别人请求的时候有可能得到这个conn，而你要在发出请求的时候，会从ThreadLocal中
        按照当前请求的线程作为key，查找其对应的conn，而conn却已经被别人占用或者消失了，所以报错
