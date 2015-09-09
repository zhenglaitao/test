package com.insigma.siis.local.pagemodel.WangLinYangTest;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.insigma.odin.framework.persistence.HBUtil;
import com.insigma.odin.framework.radow.PageModel;
import com.insigma.odin.framework.radow.RadowException;
import com.insigma.odin.framework.radow.annotation.EventDataRange;
import com.insigma.odin.framework.radow.annotation.NoRequiredValidate;
import com.insigma.odin.framework.radow.annotation.PageEvent;
import com.insigma.odin.framework.radow.event.EventRtnType;


public class DiseasePageModel  extends PageModel {
	public int doInit()
	{	
		this.setNextEventName("grid6.dogridquery");
		this.setNextEventName("grid1.dogridquery");
		this.setNextEventName("grid2.dogridquery");
		return  EventRtnType.NORMAL_SUCCESS;		
	}

	@PageEvent("grid6.dogridquery")
	@EventDataRange("panel_content")
	@NoRequiredValidate
	public int dogrid6Query(int start,int limit) throws Exception{
		//全部查询
		String sql = "  select  a.akc193 akc193 , a.ekc004 ekc004,a.aae044  aae044,min( to_char(a.eke130,'yyyyMMdd')) begintime," +
				"max(  to_char(a.eke130,'yyyyMMdd') ) endtime,b.aae140 aae140,a.aka078 aka078,sum(b.akc264) akc264,sum(b.elc007) elc007,count(1) count  " +
				"from kc29 a,kc25 b where a.aaz217=b.aaz217  and a.akc193 is not null      ";
		String sql2=" group by a.akc193,a.ekc004,a.aae044,b.aae140,a.aka078";
		
		//根据条件进行查询
		String  begintime = this.getPageElement("panel_content.begintime").getValue();
		String  endtime = this.getPageElement("panel_content.endtime").getValue();
        //把日期格式从2015-05-01转变成20150501
        String begintimes=begintime.replace("-","" );
        String endtimes=endtime.replace("-","" );        
		String  ake002 = this.getPageElement("panel_content.ake002").getValue();
		String  aaz107 = this.getPageElement("panel_content.aaz107").getValue();
		String  aka078 = this.getPageElement("panel_content.aka078").getValue();
		String  aae140 = this.getPageElement("panel_content.aae140").getValue();
		if(begintime!=null&&!begintime.equals(""))
		{
			sql=sql+"  and to_char(a.eke130, 'yyyyMMdd')>= '"+begintimes+"'";
		}
		if(endtime!=null&&!endtime.equals(""))
		{
			sql=sql+"  and  to_char(a.eke131, 'yyyyMMdd')<= '"+endtimes+"'";
		}
		if(ake002!=null&&!ake002.equals(""))
		{
			sql=sql+"  and a.ekc004 like  '%"+ake002+"%'";
		}
		if(aaz107!=null&&!aaz107.equals(""))
		{
			sql=sql+"   and a.aaz107= '"+aaz107+"'";
		}
		if(aka078!=null&&!aka078.equals(""))
		{
			sql=sql+"  and a.aka078= '"+aka078+"'";
		}
		if(aae140!=null&&!aae140.equals(""))
		{
			sql=sql+"   and b.aae140= '"+aae140+"'";
		}		
		this.pageQuery(sql+sql2,"SQL", start, limit); //处理分页查询
		return EventRtnType.SPE_SUCCESS;
	}

	
	@PageEvent("grid1.dogridquery")
	@NoRequiredValidate
	public int dogrid1Query(int start,int limit) throws Exception{	 
		
		//页面初始化的时候获取gird6查询的第一行数据来获取参数作为条件执行查询
		String sql1 = "  select  a.akc193 akc193 , a.ekc004 ekc004,a.aae044  aae044,min( to_char(a.eke130,'yyyyMMdd')) begintime," +
		"max(  to_char(a.eke130,'yyyyMMdd') ) endtime,b.aae140 aae140,a.aka078 aka078,sum(b.akc264) akc264,sum(b.elc007) elc007,count(1) count  " +
		"from kc29 a,kc25 b where a.aaz217=b.aaz217  and a.akc193 is not null      ";
        String sql22=" group by a.akc193,a.ekc004,a.aae044,b.aae140,a.aka078";
        Connection conn = HBUtil.getHBSession().connection();
        ResultSet rs = conn.createStatement().executeQuery(sql1+sql22);
        ResultSetMetaData rsmd = rs.getMetaData();
        List<HashMap<String, Object>>  maplist =  new ArrayList<HashMap<String,Object>>();
        int cols = rsmd.getColumnCount();
        while(rs.next()){
        	HashMap<String, Object> map = new HashMap<String, Object>();
        	for(int i = 1 ;i<=cols;i++){
        		map.put(rsmd.getColumnName(i).toLowerCase().toString(), rs.getString(i));
        	}
        	maplist.add(map);
        }
        HashMap<String, Object> map = maplist.get(0);
        String akc193 = map.get("akc193").toString();
    	System.out.println(akc193+"-----------akc193");
        String aae140 = map.get("aae140").toString();
        String aka078 = map.get("aka078").toString();
        String aae044 = map.get("aae044").toString();
        
        //双击之后从前台隐藏变量里面获取参数
    	String  akc193_1 = this.getPageElement("akc193_1").getValue();		
		String  aae044_1 = this.getPageElement("aae044_1").getValue();
		String  aka078_1 = this.getPageElement("aka078_1").getValue();
		String  aae140_1 = this.getPageElement("aae140_1").getValue();
		if(akc193!= null && !akc193.equals("") && aae140!=null&&!aae140.equals("") && aka078!=null&&!aka078.equals("") && aae044!=null&&!aae044.equals(""))
		{
			String sql = "select distinct b.ake001 ake001, b.ake006 ake006,b.ake003 ake003,sum(b.akc226) num,sum( (b.aae019-b.akc228)) baoxiaofeiyong, " +
			" to_char(  round(  (sum( (b.aae019-b.akc228)) )/" +
			"( select sum(b.aae019-b.akc228)  from kc22 b ,kc29 a  where  b.aaz217=a.aaz217  and a.akc193='"+akc193+"'"+"  and a.aka078='"+aka078+"'";
	        String sql2= " ), 2)*100,'990.99') || '%'  feiyongzb,"; 
	        String sql3=" to_char(   round(  count(distinct b.aaz217)/" +
			"( select count(distinct a.aaz217)    from kc25 a ,kc29 b  where a.aaz217=b.aaz217  and  b.aka078='" +aka078+"'"+"  and b.akc193='"+akc193+"'";
	        String sql4=	" ),2)*100,'990.99') || '%'  rencizb    from kc22 b , kc29 a ,kc25 c where b.aaz217=a.aaz217 and b.aaz217=c.aaz217  and c.aae140='"+aae140+"'" +"   and  a.akc193='"+akc193+"'"+" and a.aka078='"+aka078+"'" +"  and  a.aae044='"+aae044+"'";
	        String sql5=	"group by   b.ake001,   b.ake006,b.ake003 ";	
        	this.pageQuery(sql+sql2+sql3+sql4+sql5,"SQL", start, limit);
		}
		if(akc193_1!= null && !akc193_1.equals("") && aae140_1!=null&&!aae140_1.equals("") && aka078_1!=null&&!aka078_1.equals("") && aae044_1!=null&&!aae044_1.equals(""))
		{
		
			String sql = "select distinct b.ake001 ake001, b.ake006 ake006,b.ake003 ake003,sum(b.akc226) num,sum( (b.aae019-b.akc228)) baoxiaofeiyong, " +
			"  to_char(  round(  (sum( (b.aae019-b.akc228)) )/" +
			"( select s round(  (sum( (b.aae019-b.akc228)) )/" +
			"( select sum(b.aae019-b.akc228)  from kc22 b ,kc29 a  where  b.aaz217=a.aaz217  and a.akc193='"+akc193_1+"'"+"  and a.aka078='"+aka078_1+"'";
	        String sql2= " ), 2) * 100,'990.99') || '%'  feiyongzb,"; 
	        String sql3=" to_char(   round(  count(distinct b.aaz217)/" +
			"( select count(distinct a.aaz217)  from kc25 a ,kc29 b  where a.aaz217=b.aaz217  and  b.aka078='" +aka078_1+"'"+"  and b.akc193='"+akc193_1+"'";
	        String sql4=	" ), 2) * 100,'990.99') || '%'  rencizb     from kc22 b , kc29 a ,kc25 c where b.aaz217=a.aaz217 and b.aaz217=c.aaz217  and c.aae140='"+aae140_1+"'" +"   and  a.akc193='"+akc193_1+"'"+" and a.aka078='"+aka078_1+"'" +"  and  a.aae044='"+aae044_1+"'";
        	String sql5=	"group by   b.ake001,   b.ake006,b.ake003 ";	
	    	this.pageQuery(sql+sql2+sql3+sql4+sql5,"SQL", start, limit);
		}	
	    	return EventRtnType.SPE_SUCCESS;
	}
	
	
	@PageEvent("grid2.dogridquery")
	@NoRequiredValidate
	public int dogrid2Query(int start,int limit) throws Exception{	  

		//页面初始化的时候获取gird6查询的第一行数据来获取参数作为条件执行查询
		String sql1 = "  select  a.akc193 akc193 , a.ekc004 ekc004,a.aae044  aae044,min( to_char(a.eke130,'yyyyMMdd')) begintime," +
		"max(  to_char(a.eke130,'yyyyMMdd') ) endtime,b.aae140 aae140,a.aka078 aka078,sum(b.akc264) akc264,sum(b.elc007) elc007,count(1) count  " +
		"from kc29 a,kc25 b where a.aaz217=b.aaz217  and a.akc193 is not null      ";
        String sql22=" group by a.akc193,a.ekc004,a.aae044,b.aae140,a.aka078";
        Connection conn = HBUtil.getHBSession().connection();
        ResultSet rs = conn.createStatement().executeQuery(sql1+sql22);
        ResultSetMetaData rsmd = rs.getMetaData();
        List<HashMap<String, Object>>  maplist =  new ArrayList<HashMap<String,Object>>();		
        int cols = rsmd.getColumnCount();
        while(rs.next()){
        	HashMap<String, Object> map = new HashMap<String, Object>();
        	for(int i = 1 ;i<=cols;i++){
        		map.put(rsmd.getColumnName(i).toLowerCase().toString(), rs.getString(i));
        	}
        	maplist.add(map);
        }
        HashMap<String, Object> map = maplist.get(0);
        String akc193 = map.get("akc193").toString();
        String aae140 = map.get("aae140").toString();
        String aka078 = map.get("aka078").toString();
        String aae044 = map.get("aae044").toString();
               
        //双击之后从前台隐藏变量里面获取参数
		String  akc193_2 = this.getPageElement("akc193_1").getValue();		
		String  aae044_2 = this.getPageElement("aae044_1").getValue();
		String  aka078_2 = this.getPageElement("aka078_1").getValue();
		String  aae140_2 = this.getPageElement("aae140_1").getValue();
		if(akc193!= null && !akc193.equals("") && aae140!=null&&!aae140.equals("") && aka078!=null&&!aka078.equals("") && aae044!=null&&!aae044.equals(""))
		{
		String  sql="select distinct b.aka063   aka063 , sum( (b.aae019-b.akc228))  baoxiao , to_char( round(  count(1)/( select count(b.aka063) from kc22 b , kc29 a ,kc25 c where b.aaz217=a.aaz217 and   b.aaz217=c.aaz217" ;
			String sql2=	" and   a.akc193  ='"+akc193+"'   and a.aae044='"+aae044+"'  and c.aae140='"+aae140+"'" ;
			String sql3=	"), 2) * 100,'990.99') || '%'  zb     from kc22 b , kc29 a ,kc25 c where b.aaz217=a.aaz217 and   b.aaz217=c.aaz217  " ;
			String sql4=	" and   a.akc193  ='"+akc193+"' and a.aae044='"+aae044+"' and c.aae140='"+aae140+"' " ;
			String sql5=	"group by   b.aka063";
			//执行sql，分页
	        this.pageQuery(sql+sql2+sql3+sql4+sql5,"SQL", start, limit);
		}	
		if(akc193_2!= null && !akc193_2.equals("") && aae140_2!=null&&!aae140_2.equals("") && aka078_2!=null&&!aka078_2.equals("") && aae044_2!=null&&!aae044_2.equals(""))
		{
			String  sql="select distinct b.aka063   aka063 , sum( (b.aae019-b.akc228))  baoxiao , to_char(round(  count(1)/( select count(b.aka063) from kc22 b , kc29 a ,kc25 c where b.aaz217=a.aaz217 and   b.aaz217=c.aaz217" ;
			String sql2=	" and   a.akc193  ='"+akc193_2+"'   and a.aae044='"+aae044_2+"'  and c.aae140='"+aae140_2+"'" ;
			String sql3=	" ), 2) * 100,'990.99') || '%' zb     from kc22 b , kc29 a ,kc25 c where b.aaz217=a.aaz217 and   b.aaz217=c.aaz217  " ;
			String sql4=	" and   a.akc193  ='"+akc193_2+"' and a.aae044='"+aae044_2+"' and c.aae140='"+aae140_2+"' " ;
			String sql5=	"group by   b.aka063";
			//执行sql，分页
        	this.pageQuery(sql+sql2+sql3+sql4+sql5,"SQL", start, limit);	
		}
		return EventRtnType.SPE_SUCCESS;
	}

	//查询按钮
	@PageEvent("toolBarBtn1.onclick")
	public int btnOnClick(){
		this.setNextEventName("grid6.dogridquery");
		return EventRtnType.NORMAL_SUCCESS;
}
	
	//重置按钮
	@PageEvent("canel.onclick")
	public int clear() throws RadowException{
		this.reloadPage();
		return EventRtnType.NORMAL_SUCCESS;
	}

	//双击
	@PageEvent("grid6.rowdbclick")
	public int loadpage() throws Exception{
		
		//从gird6获取你点击的那一行数据
		List<HashMap<String, Object>> list = this.getPageElement("grid6").getValueList();
        HashMap<String, Object> map = list.get(0);
        String akc193 = map.get("akc193").toString();
        String aae140 = map.get("aae140").toString();
        String aka078 = map.get("aka078").toString();
        String aae044 = map.get("aae044").toString();
        String data="[";
        for(int i=0;i<list.size();i++){
        	HashMap<String, Object> map = list.get(i);
        	String name=map.get("目录名称").toString();
        	String value=map.get("占比").toString();
        	data+="["+name+","+value+"],";
        }
        data=data.substring(0,data.lastIndexOf(","));
        data+="]";
        //传过来的参数是字符串，但是通过js传到页面的时候变成数字类型了，所以下面的加上单引号
        //赋值给前台页面隐藏的变量
		this.getPageElement("akc193_1").setValue(akc193);
		this.getPageElement("aae140_1").setValue(aae140);
		this.getPageElement("aka078_1").setValue(aka078);
		this.getPageElement("aae044_1").setValue(aae044);
		
		//调用gird1和gird2的方法
		this.setNextEventName("grid1.dogridquery");
		this.setNextEventName("grid2.dogridquery");
		return  EventRtnType.NORMAL_SUCCESS;		
	}
}

	