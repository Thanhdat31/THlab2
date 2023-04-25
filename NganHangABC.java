import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class NganHangABC {
     private long sTK = 999999;
     private String tTK = "chưa xác định";
     private double sTTTK = 50;
     private String tT ;
      public NganHangABC(long sTK, String tTK, double sTTTK, String tT) {
    	  super();
    	  this.sTK = sTK;
    	  this.tTK = tTK;
    	  this.sTTTK = sTTTK;
    	  this.tT = tT;
    	  }
	public long getsTK() {
		return sTK;
	}
	public void setsTK(long sTK) {		
		if(sTK > 0 && sTK < 999999) {
			this.sTK = sTK;
		}
		else {
			this.sTK = 999999;
			this.tT = "Số tài khoản không hợp lệ";
		}
	}
	public String gettTK() {
		return tTK;
	}
	public void settTK(String tTK) {
		if(tTK != null && !tTK.isEmpty()){
		this.tTK = tTK;
		}
		else {
			this.tTK = "chưa xác định";
			this.tT = "Tên tài khoản không hợp lệ";
		}
	}
	public double getsTTTK() {
		return sTTTK;
	}
	public void setsTTTK(double sTTTK) {
		if(sTTTK >=50) {			
		this.sTTTK = sTTTK;
		}
		else {
		this.sTTTK = 50;
		this.tT = "Bạn nghèo quá không cho rút tiền";
		}
	}
	public String gettT() {
		return tT;
	}
	public void settT(String tT) {
		this.tT = tT;
	}
	public String toString() {
		NumberFormat formatter = null;
		String formatedformatter = formatter.format(sTK);
	 return "thông tin tài khoản: Số tài khoản:"+ getsTK()+ ", Tên tài khoản: "+gettTK()+", Số tiền: "+ formatedformatter +", Trang thái:"+gettT();
	}
}
class Account{
	private String soTK;
	private String tenTK;
	private double soTien = 50;
	private final double laixuat = 0.035;
	public Account(String soTK, String tenTK, double soTien ) {
		this.soTien = soTien;
		this.soTK = soTK;
		this.tenTK = tenTK;
	}
	public String getSoTK() {
		return soTK;
	}
	public void setSoTK(String soTK) {
		this.soTK = soTK;
	}
	public String getTenTK() {
		return tenTK;
	}
	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}
	public double getSoTien() {
		return soTien;
	}
	public void setSoTien(double soTien) {
		this.soTien = soTien;
	}
	public void naptien(double soluong)
	{
		soTien += soluong;
	}
	public void ruttien(double soluong) {
		if(soluong <= soTien) {
			soTien -= soluong;
		}else {
			System.out.println("Số tiền không đủ");
		}
	}
	public void chuyenkhoan(Account nguoinhan, double soluong) {
		if(soluong <= soTien) {
			soTien -= soluong;
			nguoinhan.soTien += soluong;
		}
		else {
			System.out.println("Số tiền không đủ");
			
		}
	}
	public void daohan() {
		soTien += soTien * laixuat;
	}
}
class AccountList{
	private Account[] accList;
	private int count;
	public AccountList() {
		accList = new Account[10];
		count = 0;
	}
	public AccountList(int n) {
		if(n>0) {
			accList = new Account[n];
		}else {
			accList = new Account[10];
		}
		count = 0;
	}
	public boolean addAcount(Account taikhoan) {
		if(count < accList.length) {
			accList[count] = taikhoan;
			count++;
			return true;}
		return false;
	}
	  public Account findAccount(String accNum) {
	        for (int i = 0; i < count; i++) {
	            if (accList[i].getSoTK().equals(accNum)) {
	                return accList[i];
	            }
	        }
	        return null;
	    }

	    public boolean deleteAccount(String accNum) {
	        for (int i = 0; i < count; i++) {
	            if (accList[i].getSoTK().equals(accNum)) {
	                accList[i] = accList[count-1];
	                accList[count-1] = null;
	                count--;
	                return true;
	            }
	        }
	        return false;
	    }

	    public int getNumberOfAccounts() {
	        return count;
	    }

	    public void printAccountList() {
	        System.out.println("Account List:");
	        for (int i = 0; i < count; i++) {
	            System.out.println(accList[i]);
	        }
	    }
	    public static void main(String[] args) {
	        Account a[] = null;
	        int  b, n = 0;
	        long s, d, c, f;
	        boolean flag = true;
	        do {
	            System.out.println("Bạn chọn làm gì: ");
	            System.out.println("1.Nhap thong tin cua khach hang \n"
	                    + "2.Xuat thong tin \n" + "3.Nap tien \n" + "4.Rut tien \n"
	                    + "5.Dao han\n" + "6.Chuyen khoan \n" + "thoat ");
	            b = sc.nextInt();
	            switch (b) {
	                case 1:
	                    System.out.println("Nhap so luong khach muon nhap ");
	                    n = sc.nextInt();
	                    a = new Account[n];
	                    for (int i = 0; i < n; i++) {
	                        System.out.println("Khách hàng số: " + (i+1));
	                        a[i] = new Account();
	                        nhapTK(a[i]);
	                    }
	                    break;
	                case 2:
	                    System.out.printf("%-10s %-20s %-20s\n", "Số TK", "Tên TK", "Số tiền trong TK");
	                    for (int i = 0; i < n; i++) {
	                        a[i].inTK();
	                    }
	                    break;
	                case 3:
	                    System.out.println("Nhập số tài khoản khách hàng cần nạp tiền: ");
	                    s = sc.nextLong();
	                    for (int i = 0; i < n; i++) {
	                        d = a[i].getSoTK();
	                        if (s == d) {
	                            System.out.println("Bạn chọn tài khoản: " + d);
	                            a[i].napTien();
	                        } else {
	                            System.out.println("");
	                        }
	                    }
	                    break;
	                case 4:
	                    System.out.println("Nhập số tài khoản khách hàng cần rút tiền: ");
	                    s = sc.nextLong();
	                    for (int i = 0; i < n; i++) {
	                        d = a[i].getSoTK();
	                        if (s == d) {
	                            System.out.println("Bạn chọn tài khoản: " + d);
	                            a[i].rutTien();
	                        }
	                    }
	                    break;
	                case 5:
	                    System.out.println("Nhập số tài khoản khách hàng cần đáo hạn: ");
	                    s = sc.nextLong();
	                    for (int i = 0; i < n; i++) {
	                        d = a[i].getSoTK();
	                        if (s == d) {
	                            System.out.println("Bạn chọn tài khoản: " + d);
	                            a[i].daoHan();
	                        } else {
	                            System.out.println("");
	                        }
	                    }
	                    break;
	                case 6:
	                    double chuyen,
	                            nhan,
	                            tienChuyen;
	                    System.out.print("Nhập số tài khoản khách hàng chuyển tiền: ");
	                    s = sc.nextLong();
	                    System.out.print("Nhập số tài khoản khách hàng nhận tiền: ");
	                    c = sc.nextLong();
	                    for (int i = 0; i < n; i++) {
	                        d = a[i].getSoTK();
	                        if (s == d) {
	                            chuyen = a[i].getsTTTK();
	                            for (int j = 0; j < n; j++) {
	                                f = a[j].getSoTK();
	                                if (c == f) {
	                                    nhan = a[j].getSoTienTrongTK();
	                                    System.out.println("Nhập số tiền cần chuyển");
	                                    tienChuyen = sc.nextDouble();
	                                    if (tienChuyen <= chuyen) {
	                                        chuyen = chuyen - tienChuyen;
	                                        nhan = nhan + tienChuyen;
	                                        a[i].setSTK(chuyen);
	                                        a[j].setsTTK(nhan);
	                                        System.out.println("Tài khoản số " + d + " vừa chuyển: $" + tienChuyen);
	                                        System.out.println("Tài khoản số " + f + " vừa nhận: $" + tienChuyen);
	                                    } else {
	                                        System.out.println("Số tiền nhập không hợp lệ!");
	                                    }
	                                } else {
	                                    System.out.println("");
	                                }
	                            }
	                        } else {
	                            System.out.println("");
	                        }
	                    }
	                    break;
	                default:
	                    System.out.println("Bye!!");
	                    flag = false;
	                    break;
	            }
	        } while (flag);
	    
	}
		}
  




