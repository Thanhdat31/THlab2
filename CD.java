
import java.util.Scanner;

public class CD {
	
	    private int maCD;
	    private String tenCD;
	    private String caSy;
	    private int soBH;
	    private float giaThanh;

	    public CD() {
	    }
	    public CD(int cD, String tenCD, String caSy, int soBH, float giaThanh) {
	        this.maCD = maCD;
	        this.tenCD = tenCD;
	        this.caSy = caSy;
	        this.soBH = soBH;
	        this.giaThanh = giaThanh;
	    }
	   
	    public int getMaCD() {
	        return maCD;
	    }
	 
	    public void setMaCD(int maCD) {
	        this.maCD = maCD;
	    }
	 
	    public String getTenCD() {
	        return tenCD;
	    }
	 
	    public void setTenCD(String tenCD) {
	        this.tenCD = tenCD;
	    }
	 
	    public String getCaSy() {
	        return caSy;
	    }
	 
	    public void setCaSy(String caSy) {
	        this.caSy = caSy;
	    }
	 
	    public int getSoBH() {
	        return soBH;
	    }
	 
	    public void setSoBH(int soBH) {
	        this.soBH = soBH;
	    }
	 
	    public float getGiaThanh() {
	        return giaThanh;
	    }
	 
	    public void setGiaThanh(float giaThanh) {
	        this.giaThanh = giaThanh;
	    }
	  
	    @Override
	    public String toString() {
	        return "Album{" +
	                "cD=" + maCD +
	                ", tenCD='" + tenCD +"" +
	                ", caSy='" + caSy + "" +
	                ", soBH=" + soBH +
	                ", giaThanh=" + giaThanh +
	                '}';
	    }
	    public void hienThiAlbum(){
	        System.out.printf("%-10d %-20s %-20s %-10d %-20.1f \n",maCD,tenCD,caSy,soBH,giaThanh);
	    }
	 
	}


	 
	 class Main {
	    static Scanner sc = new Scanner(System.in);
	    static void nhapAlbum(CD ab) {
	        System.out.print("Nhap ma CD: ");
	        ab.setMaCD(sc.nextInt());
	        sc.nextLine();
	        System.out.print("Nhap ten CD : ");
	        ab.setTenCD(sc.nextLine());
	        System.out.print("Nhap ten ca si,dien vien : ");
	        ab.setCaSy(sc.nextLine());
	        System.out.print("Nhap so luong bai hat : ");
	        ab.setSoBH(sc.nextInt());
	        System.out.print("Nhap gia thanh : ");
	        ab.setGiaThanh(sc.nextFloat());
	    }
	    public static void main(String[] args) {
	        CD alb[] = null;
	        int a, n = 0;
	        boolean flag = true;
	        do {
	            System.out.println("Ban chon lam gi?");
	            System.out.println("1.Nhap thong tin CD \n" +
	                    "2.Xuat danh sach Album.\n" + "3.Tinh tong gia thanh \n" + "4.Tong so luong CD \n" +
	                    "5.Sap xep giam dan theo gia thanh\n"+"6.Sap xep tang dan theo tua CD\n"+"Nhap so khac de exit");
	            a = sc.nextInt();
	            switch (a) {
	                case 1:
	                    System.out.println("Nhap so luong CD : ");
	                    n = sc.nextInt();
	                    alb = new CD[n];
	                    for (int i = 0; i < n; i++) {
	                        System.out.println("CD thu " + (i + 1)+": ");
	                        alb[i] = new CD();
	                        nhapAlbum(alb[i]);
	                    }
	                    break;
	                case 2:
	                    System.out.printf("%-10s %-20s %-20s %-10s %-20s \n", "Mã CD", "Tên CD", "Tên ca sỹ", "Số bài hát", "Giá thành");
	                    for (int i = 0; i < n; i++) {
	                        alb[i].hienThiAlbum();
	                    }
	                    break;
	                case 3:
	                    int tong = 0;
	                    for (int i = 0; i < n; i++) {
	                        tong += alb[i].getGiaThanh();
	                    }
	                    System.out.println("" +
	                            "Tong gia thanh la : " + tong);
	                    break;
	                case 4:
	                    System.out.println("Tong so luong CD la : " + n);
	                    break;
	                case 5:
	                    CD temp = alb[0];
	                    for (int i = 0; i < n - 1; i++) {
	                        for (int j = i + 1; j < n; j++) {
	                            if (alb[i].getGiaThanh() < alb[j].getGiaThanh()) {
	                                temp = alb[j];
	                                alb[j] = alb[i];
	                                alb[i] = temp;
	                            }
	                        }
	                    }
	                    System.out.println("sap xep thanh cong, Nhap so 2 de kiem tra!");
	                    break;
	                case 6:
	                    temp = alb[0];
	                    for (int i = 0; i < n - 1; i++) {
	                        for (int j = i + 1; j < n; j++) {
	                            if (alb[i].getTenCD().compareTo(alb[j].getTenCD())>0) {
	                                temp = alb[j];
	                                alb[j] = alb[i];
	                                alb[i] = temp;
	                            }
	                        }
	                    }
	                    System.out.println("sap xep thanh cong, Nhap so 2 de kiem tra!");
	                    break;
	                default:
	                    System.out.println("Goodbye");
	                    flag = false;
	                    break;
	            }
	        }while (flag) ;
	    }
	}

	    



