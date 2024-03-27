package t8_insa;

import java.sql.SQLException;
import java.util.Vector;

public class InsaDAO extends DBConn {
	InsaVO vo = null;

	// 회원 개별 조회(성명 중복체크)
	public InsaVO getNameSearch(String name) {
		InsaVO vo = new InsaVO();
		
		try {
			sql = "select * from insa2 where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setIpsail(rs.getString("ipsail"));
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 오류"+e.getMessage());
		} finally {
			rsClose();
		}
		
		return vo;
	}

	// 회원가입처리
	public int setInsaInput(InsaVO vo) {
		int res = 0;		
		try {
			sql = "insert into insa2 values (default,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getGender());
			pstmt.setString(4, vo.getIpsail());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류"+e.getMessage());
		} finally {
			pstmtClose();
		}		
		return res;
	}

	// 회원정보 수정처리
	public int setInsaUpdate(InsaVO vo) {
		int res = 0;		
		try {
			sql = "update insa2 set age=?,gender=?,ipsail=? where name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getAge());
			pstmt.setString(2, vo.getGender());
			pstmt.setString(3, vo.getIpsail());
			pstmt.setString(4, vo.getName());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류"+e.getMessage());
		} finally {
			pstmtClose();
		}	
		return res;
	}

	// 회원 삭제처리
	public int setInsaDelete(String name) {
		int res = 0;
		try {
			sql="delete from insa2 where name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류"+e.getMessage());
		} finally {
			pstmtClose();
		}	
		return res;
	}

	public Vector getInsaList(String str, String order) {
		Vector vData = new Vector<>();
		try {
			if(str.equals("ipsail") && order.equals("a")) {
				sql="select * from insa2 order by ipsail";
			}
			else if(str.equals("ipsail") && order.equals("d")) {
				sql="select * from insa2 order by ipsail desc";
			}
			else {
				sql="select * from insa2 order by idx desc";				
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vector vo = new Vector<>(); // Vector에 넣기 위해 vo도 Vector타입으로 만들어줘야 함
				vo.add(rs.getInt("idx")); // DB를 rs에 담아서 다시 vo로 옮기는 중
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail").substring(0,10));
				
				vData.add(vo); // vo에 담은 것을 Vector에 담아서 출력...
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류"+e.getMessage());
		} finally {
			rsClose();
		}	
		return vData;
	}

	// 조건 검색
	public Vector getConditionSearch(String fieldName, String txtCondi) {
		Vector vData = new Vector<>();
		try {
			sql="select * from insa2 where "+fieldName+" like ? order by name"; // 필드명은 ?가 아니라 변수로 넣어야함
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+txtCondi+"%"); // ?에 값을 지정해줄 때 %를 같이 넣으면 '%?%' << 로 인식(작은따옴표 포함으로 인식)
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>(); // Vector에 넣기 위해 vo도 Vector타입으로 만들어줘야 함
				vo.add(rs.getInt("idx")); // DB를 rs에 담아서 다시 vo로 옮기는 중
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail").substring(0,10));
				
				vData.add(vo); // vo에 담은 것을 Vector에 담아서 출력...
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류"+e.getMessage());
		} finally {
			rsClose();
		}	
		return vData;
	}
	
}
