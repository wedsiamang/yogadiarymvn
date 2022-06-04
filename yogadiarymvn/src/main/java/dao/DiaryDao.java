package dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Diary;

public class DiaryDao {
	
	//データベース接続に使用する情報
			private final String JDBC_URL="jdbc:postgresql://localhost:5432/memo";
		    private final String DB_USER= "postgres";
		    private final String DB_PASS = "test";
	
		    public void insert_diary_myName(String loginName)throws FileNotFoundException{
				
		    	Connection conn =null;
		    	PreparedStatement st =null;
		    	
		    	
				  try {
			            Class.forName("org.postgresql.Driver");
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
					try{
						conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
					
					//	conn.setAutoCommit(false);
						String sql = "INSERT INTO diary(myName,date,weather,covid19,BBT,time,series,teacher,condition,breath,vanda,dristi,lunch,dinner,morning)"
								+ "values(?,'2022-01-01','sunny','0','36.0','6:00','full-primary','self','good','★','★','★','','','')";
						
							st = conn.prepareStatement(sql);
							
							st.setString(1, loginName);
							
							st.executeUpdate();
						//	conn.commit();
						
					}catch(SQLException e) {
						System.out.println("SQLの例外が発生しました");
						e.printStackTrace();

					}finally {
			    		
			    		if(st !=null) {
			    			try{
			    				st.close();
			    				
			    			}catch(SQLException e) {
			    			}	
			    		}
			    		if(conn !=null) {
			    			try {
			    				conn.close();
			    			
			    			}catch(SQLException e) {
			    		}
			    		}
			    	}	
				}
		    
		    public List<String>get_myName(){
		     	
		    	Connection conn =null;
		    	PreparedStatement st =null;
		    	ResultSet rs =null;
		    	
				try {
		         Class.forName("org.postgresql.Driver");
				} catch (Exception e) {
		         e.printStackTrace();
				}
				
				List<String>myNameList = new ArrayList<String>();
				Diary d;	
				//データベース接続
				try { 
					conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
				//	conn.setAutoCommit(false);
					//SELECT文の準備
					String sql=
						"SELECT myName FROM diary";
					st= conn.prepareStatement(sql);	
					//SELECT文を実行
					 rs =st.executeQuery();
				
					//SELECT文の結果をARRAYLIST に格納
						while(rs.next()) {
					
						String myNames=rs.getString("myName");
					
						myNameList.add(myNames);
					//	conn.commit();
						}return myNameList;
				}catch(SQLException e){
					e.printStackTrace();
					return myNameList;
				}finally {
		    		
		    		if(st !=null) {
		    			try{
		    				st.close();
		    				
		    			}catch(SQLException e) {
		    			}	
		    		}
		    		if(conn !=null) {
		    			try {
		    				conn.close();
		    			
		    			}catch(SQLException e) {
		    		}
		    		}
		    	}	
			
		    }	    
		    
		    
	  
	  public void insert_diary_info(String loginName,String date,String weather,String covid19,String BBT,String time,String series,String teacher,String condition,String breath,String vanda,String dristi,String lunch,String dinner,String morning)throws FileNotFoundException{
			
		  	Connection conn =null;
	    	PreparedStatement st =null;
		  
		  try {
	            Class.forName("org.postgresql.Driver");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			try {
				conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
			//	conn.setAutoCommit(false);
				String sql = "INSERT INTO diary(myName,date,weather,covid19,BBT,time,series,teacher,condition,breath,vanda,dristi,lunch,dinner,morning)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				
					st= conn.prepareStatement(sql);
					String a="";
					int count=1;
					st.setString(count, loginName);
					count++;
					
					st.setString(count, date);
					count++;
					
					if(weather!=null) {
					st.setString(count, weather);
					count++;
					}else {
						st.setString(count, a);
						count++;
					}
					if(covid19!=null) {
						st.setString(count, covid19);
						count++;
						}else {
							st.setString(count, a);
							count++;
						}
					if(BBT!=null) {
					st.setString(count, BBT);
					count++;
					}else {
						st.setString(count, a);
						count++;
					}
					if(time!=null) {
					st.setString(count, time);
					count++;
					}else {
						st.setString(count, a);
						count++;
					}
					if(series!=null) {
					st.setString(count,series);
					count++;
					}else {
						st.setString(count, a);
						count++;
					}
					
					st.setString(count,teacher);
					count++;
					
					if(condition!=null) {
					st.setString(count,condition);
					count++;
					}else {
						st.setString(count, a);
						count++;
					}
					if(breath!=null) {
					st.setString(count,breath);
					count++;
					}else{
						st.setString(count, a);
						count++;
					}	
					if(vanda!=null) {
					st.setString(count,vanda);
					count++;
					}else {
						st.setString(count, a);
						count++;
					}
					if(dristi!=null){
					st.setString(count,dristi);
					count++;
					}else{
						st.setString(count, a);
						count++;
					}
					if(lunch!=null) {
					st.setString(count,lunch);
					count++;
					}else {
						st.setString(count, a);
						count++;
					}
					if(dinner!=null) {
					st.setString(count,dinner);
					count++;
					}else {
						st.setString(count, a);
						count++;
					}
					if(morning!=null) {
					st.setString(count,morning);
					count++;
					}else {
						st.setString(count, a);
						count++;
					}
				
					st.executeUpdate();
				//	conn.commit();
				
			}catch(SQLException e) {
				System.out.println("SQLの例外が発生しました");
				e.printStackTrace();
			}finally {
	    		
	    		if(st !=null) {
	    			try{
	    				st.close();
	    				
	    			}catch(SQLException e) {
	    			}	
	    		}
	    		if(conn !=null) {
	    			try {
	    				conn.close();
	    			
	    			}catch(SQLException e) {
	    		}
	    		}
	    	}	
			
		}
	  //選択した１日分の日記情報取得
	  public Diary select_diary(String loginName,int id) {
		  
		  	Connection conn =null;
	    	PreparedStatement st =null;
	    	ResultSet rs =null;
		  
		 Diary d= new Diary();	
		    	
			try {
		        Class.forName("org.postgresql.Driver");
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
			//SELECT文の準備
				
		//データベース接続
			try{
				conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
			
			//	conn.setAutoCommit(false);
				String sql=
						"SELECT * FROM DIARY WHERE myName=? AND id=?";

				st = conn.prepareStatement(sql);
			
				st.setString(1, loginName);
					st.setInt(2, id);
			
					//SELECT文を実行
					rs=st.executeQuery();
			
				//SELECT文の結果をARRAYLIST に格納
				while(rs.next()) {
					String myName=loginName;
					id=id;				
					String date=rs.getString("date");
					String weather=rs.getString("weather");
					String covid19=rs.getString("covid19");
					String BBT=rs.getString("BBT");
					String time=rs.getString("time");
					String series=rs.getString("series");
					String teacher=rs.getString("teacher");
					String condition=rs.getString("condition");
					String breath=rs.getString("breath");
					String vanda=rs.getString("vanda");
					String dristi=rs.getString("dristi");
					String lunch=rs.getString("lunch");
					String dinner=rs.getString("dinner");
					String morning=rs.getString("morning");
					d=new Diary(myName,id,date,weather,covid19,BBT,time,series,teacher,condition,breath,vanda,dristi,lunch,dinner,morning);
				//	conn.commit();
					System.out.println(id+myName+date+series);
					}return d;
		    }catch(SQLException e) {
				System.out.println("SQLの例外が発生しました");
				e.printStackTrace();
		    }finally {
	    		
	    		if(st !=null) {
	    			try{
	    				st.close();
	    				
	    			}catch(SQLException e) {
	    			}	
	    		}
	    		if(conn !=null) {
	    			try {
	    				conn.close();
	    			
	    			}catch(SQLException e) {
	    		}
	    		}
	    	}	return d;
	  }
	  //日記削除
	  public  boolean drop_diary(int id,String loginName) {
		  
			Connection conn =null;
	    	PreparedStatement st =null;
	    	int rs =0;
		  
		try {
	        Class.forName("org.postgresql.Driver");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		//SELECT文の準備
		try{
			conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
		
		//	conn.setAutoCommit(false);
			String sql=
					"DELETE FROM DIARY WHERE myName=? AND ID=? ";
			//データベース接続
				st = conn.prepareStatement(sql);
				
			//	conn.setAutoCommit(false);
				st.setString(1, loginName);
				st.setInt(2,id);
				//SELECT文を実行
				 rs=st.executeUpdate();
				System.out.println(id+loginName);
			//	conn.commit();
				if(rs !=1) {
					return false;
				}
			}catch(SQLException e) {
	
			e.printStackTrace();
			System.out.println("SQLの例外が発生しました。");
			return false;
			}finally {
	    		
	    		if(st !=null) {
	    			try{
	    				st.close();
	    				
	    			}catch(SQLException e) {
	    			}	
	    		}
	    		if(conn !=null) {
	    			try {
	    				conn.close();
	    			
	    			}catch(SQLException e) {
	    		}
	    		}
			}	
		return true;
			}
	  
	 
	  public boolean update_diary(String loginName,int id,String date,String weather,String covid19,String BBT,String time,String series,String teacher,String condition,String breath,String vanda,String dristi,String lunch,String dinner,String morning){

		  Connection conn =null;
	    	PreparedStatement st =null;
	    	int rs =0;
		  
			try {
		        Class.forName("org.postgresql.Driver");
		    } catch (Exception e) {
		        e.printStackTrace();
		    }	
			//データベース接続
			try {
				conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
			
		//		conn.setAutoCommit(false);
				//SELECT文の準備
				String sql=
						"UPDATE Diary SET date=?,weather=?,covid19=?,BBT=?,time=?,series=?,teacher=?,condition=?,breath=?,vanda=?,dristi=?,lunch=?,dinner=?,morning=? WHERE id=? AND myName=?";
				
				//SELECT文を実行
				 st= conn.prepareStatement(sql);
				 
				int count=1;		
				String a="";
				if(date.equals("")==false) {
					st.setString(count,date);
					count++;
				}
				if(weather.equals("")==false) {
					st.setString(count, weather);
					count++;
				}else {
					st.setString(count, a);
					count++;
				}
				if(covid19.equals("")==false) {
					st.setString(count, covid19);
					count++;
				}else {
					st.setString(count, a);
					count++;
				}
				
				if(BBT.equals("")==false) {
					st.setString(count,BBT);
					count++;
				}else {
					st.setString(count,a);
					count++;
				}
				if(time.equals("")==false) {
					st.setString(count,time);
					count++;
				}else {
					st.setString(count,a);
					count++;
				}
				if(series.equals("")==false) {
					st.setString(count,series);
					count++;
				}else {
					st.setString(count,a);
					count++;
				}
				if(teacher.equals("")==false) {
					st.setString(count,teacher);
					count++;
				}else {
					st.setString(count,a);
					count++;
				}
				if(condition.equals("")==false) {
					st.setString(count,condition);
					count++;
				}else {
					st.setString(count,a);
					count++;
				}
				if(breath!=null) {
					st.setString(count,breath);
					count++;
				}else {
					st.setString(count,a);
					count++;
				}
				if(vanda!=null) {
					st.setString(count,vanda);
					count++;
				}else {
					st.setString(count,a);
					count++;
				}
				if(dristi!=null) {
					st.setString(count,dristi);
					count++;
				}else {
					st.setString(count,a);
					count++;
				}
				if(lunch.equals("")==false) {
					st.setString(count,lunch);
					count++;
				}else {
					st.setString(count,a);
					count++;
				}
				if(dinner.equals("")==false) {
					st.setString(count,dinner);
					count++;
				}else {
					st.setString(count,a);
					count++;
				}
				if(morning.equals("")==false) {
					st.setString(count,morning);
					count++;
				}else {
					st.setString(count,a);
					count++;
				}
				
				st.setInt(count, id);
				count++;
		
				st.setString(count,loginName);

				rs = st.executeUpdate();
					System.out.println(id+date+teacher+vanda);
			//		conn.commit();
					if(rs != 1) {
						return false;
					}
			
			}catch(SQLException e) {
				System.out.println("SQLの例外が発生しました。");
			
				e.printStackTrace();
			}finally {
	    		
	    		if(st !=null) {
	    			try{
	    				st.close();
	    				
	    			}catch(SQLException e) {
	    			}	
	    		}
	    		if(conn !=null) {
	    			try {
	    				conn.close();
	    			
	    			}catch(SQLException e) {
	    		}
	    		}
	    	}		
			return true;
			
	  }
}
