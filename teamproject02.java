package praticeproject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class teamproject02 {
    public static void main(String[] args) {
        boolean checker = true;
        boolean checker2;
        boolean endminer = true;
        boolean allrepeater = true;
        int checkcnt = 0;
        int idcnt = 0;
        int memorial = 0;
        String cthid = "cth1";
        String cthpw = "cth2";
        String lyjid = "lyj1";
        String lyjpw = "lyj2";
        String kybid = "kyb1";
        String kybpw = "kyb2";
        String kyjid = "kyj1";
        String kyjpw = "kyj2";
        String rentaldue = null;
        Date rentalduedate = new Date();
        SimpleDateFormat timeformat =new SimpleDateFormat("MM-dd");
        Scanner scan = new Scanner(System.in);
        String humanities[] = { "�ι�å1", "�ι�å2", "�ι�å3", "�ι�å4", "�ι�å5" };
        String social[] = { "��ȸå1", "��ȸå2", "��ȸå3", "��ȸå4", "��ȸå5" };
        String science[] = { "����å1", "����å2", "����å3", "����å4", "����å5" };
        String art[] = { "����å1", "����å2", "����å3", "����å4", "����å4", "����å5" };
        ArrayList<String> cthbooklist = new ArrayList<>();
        ArrayList<String> lyjbooklist = new ArrayList<>();
        ArrayList<String> kybbooklist = new ArrayList<>();
        ArrayList<String> kyjbooklist = new ArrayList<>();
        while (allrepeater) { checker = true;
            while (checker) {
                System.out.println("����ڸ� �����ϼ��� 1:������ 2:������3:������4:�迵��");
                int w = scan.nextInt();
                memorial = w;
                if (w == 1) {
                    checkcnt = 0;
                    System.out.println("�����ƴ� id �� �Է��ϼ���");
                    String id1 = scan.next();
                    checker2 = true;
                    while (checker2) {
                        System.out.println("�����ƴ� pw �� �Է��ϼ���");
                        String pw1 = scan.next();
                        if (id1.equals(cthid) && pw1.equals(cthpw)) {
                            System.out.println("�α��� ����");
                            checker = false;
                            checker2 = false;
                        } else {
                            System.out.println("�α��� ����" + (checkcnt + 1) + "/3");
                            checkcnt++;
                            if (checkcnt == 3) {
                                checker2 = false;
                            }

                        }
                    }
                } else if (w == 2) {
                    checkcnt = 0;
                    System.out.println("�������� id �� �Է��ϼ���");
                    String id1 = scan.next();
                    checker2 = true;
                    while (checker2) {
                        System.out.println("�������� pw �� �Է��ϼ���");
                        String pw1 = scan.next();
                        if (id1.equals(lyjid) && pw1.equals(lyjpw)) {
                            System.out.println("�α��� ����");
                            checker = false;
                            checker2 = false;
                        } else {
                            System.out.println("�α��� ����" + (checkcnt + 1) + "/3");
                            checkcnt++;
                            if (checkcnt == 3) {
                                checker2 = false;
                            }

                        }
                    }
                } else if (w == 3) {
                    checkcnt = 0;
                    System.out.println("������� id �� �Է��ϼ���");
                    String id1 = scan.next();
                    checker2 = true;
                    while (checker2) {
                        System.out.println("������� pw �� �Է��ϼ���");
                        String pw1 = scan.next();
                        if (id1.equals(kybid) && pw1.equals(kybpw)) {
                            System.out.println("�α��� ����");
                            checker = false;
                            checker2 = false;
                        } else {
                            System.out.println("�α��� ����" + (checkcnt + 1) + "/3");
                            checkcnt++;
                            if (checkcnt == 3) {
                                checker2 = false;
                            }

                        }
                    }
                } else if (w == 4) {
                    checkcnt = 0;
                    System.out.println("�迵�ش� id �� �Է��ϼ���");
                    String id1 = scan.next();
                    checker2 = true;
                    while (checker2) {
                        System.out.println("�迵�ش� pw �� �Է��ϼ���");
                        String pw1 = scan.next();
                        if (id1.equals(kyjid) && pw1.equals(kyjpw)) {
                            System.out.println("�α��� ����");
                            checker = false;
                            checker2 = false;
                        } else {
                            System.out.println("�α��� ����" + (checkcnt + 1) + "/3");
                            checkcnt++;
                            if (checkcnt == 3) {
                                checker2 = false;
                            }

                        }
                    }
                }
            }
            endminer =true;
            while (endminer) {
                System.out.println("���ϴ¸޴��� �������ּ��� 1: �뿩  2: �ݳ� 3: �뿩��Ȳ  4: ����ڼ��ø޴�  5: ���� ");
                int menu = scan.nextInt();
                if (menu == 1) {
                    System.out.println("�޴�'�뿩'�� �����ϼ̽��ϴ�.");
                    System.out.println("å�� ������ �������ּ��� 1: �ι� 2: ��ȸ 3: ���� 4: ���� ");
                    int kind = scan.nextInt();
                    if (kind == 1) {
                        System.out.println("�ι��� �����ϼ̽��ϴ� å�Ǹ���� �����մϴ�");
                        for (String k : humanities) {
                            System.out.println(k);
                        }
                        System.out.println("�뿩�ϰ����ϴ� å�ǹ�ȣ�� �Է��ϼ���");
                        int booknum = scan.nextInt();
                        if (humanities[booknum - 1].length() == 4) {
                            System.out.println("�뿩������å�Դϴ�.");
                            if (memorial == 1) {
                                String bookna = humanities[booknum - 1];
                                cthbooklist.add(humanities[booknum - 1]);
                                humanities[booknum - 1] = bookna + "�뿩��";
                                System.out.println("�뿩�� ���������� �Ϸ��ϼ̽��ϴ�");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("�뿩 ���� ����:"+rentaldue);
                                
                            } else if (memorial == 2) {
                                String bookna = humanities[booknum - 1];
                                lyjbooklist.add(humanities[booknum - 1]);
                                humanities[booknum - 1] = bookna + "�뿩��";
                                System.out.println("�뿩�� ���������� �Ϸ��ϼ̽��ϴ�");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("�뿩 ���� ����:"+rentaldue);
                            } else if (memorial == 3) {
                                String bookna = humanities[booknum - 1];
                                kybbooklist.add(humanities[booknum - 1]);
                                humanities[booknum - 1] = bookna + "�뿩��";
                                System.out.println("�뿩�� ���������� �Ϸ��ϼ̽��ϴ�");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("�뿩 ���� ����:"+rentaldue);
                            } else if (memorial == 4) {
                                String bookna = humanities[booknum - 1];
                                kyjbooklist.add(humanities[booknum - 1]);
                                humanities[booknum - 1] = bookna + "�뿩��";
                                System.out.println("�뿩�� ���������� �Ϸ��ϼ̽��ϴ�");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("�뿩 ���� ����:"+rentaldue);
                            }
                        } else {
                            System.out.println("�ٸ�ȸ���� �̹� �뿩���� �����Դϴ�.");
                        }
                    } else if (kind == 2) {
                        System.out.println("��ȸ�� �����ϼ̽��ϴ� å�Ǹ���� �����մϴ�");
                        for (String k : social) {
                            System.out.println(k);
                        }
                        System.out.println("�뿩�ϰ����ϴ� å�ǹ�ȣ�� �Է��ϼ���");
                        int booknum = scan.nextInt();

                        if (social[booknum - 1].length() == 4) {
                            System.out.println("�뿩������å�Դϴ�.");
                            if (memorial == 1) {
                                String bookna = social[booknum - 1];
                                cthbooklist.add(social[booknum - 1]);
                                social[booknum - 1] = bookna + "�뿩��";
                                System.out.println("�뿩�� ���������� �Ϸ��ϼ̽��ϴ�");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("�뿩 ���� ����:"+rentaldue);
                            } else if (memorial == 2) {
                                String bookna = social[booknum - 1];
                                lyjbooklist.add(social[booknum - 1]);
                                social[booknum - 1] = bookna + "�뿩��";
                                System.out.println("�뿩�� ���������� �Ϸ��ϼ̽��ϴ�");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("�뿩 ���� ����:"+rentaldue);
                            } else if (memorial == 3) {
                                String bookna = social[booknum - 1];
                                kybbooklist.add(social[booknum - 1]);
                                social[booknum - 1] = bookna + "�뿩��";
                                System.out.println("�뿩�� ���������� �Ϸ��ϼ̽��ϴ�");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("�뿩 ���� ����:"+rentaldue);
                            } else if (memorial == 4) {
                                String bookna = social[booknum - 1];
                                kyjbooklist.add(social[booknum - 1]);
                                social[booknum - 1] = bookna + "�뿩��";
                                System.out.println("�뿩�� ���������� �Ϸ��ϼ̽��ϴ�");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("�뿩 ���� ����:"+rentaldue);
                            }
                        } else {
                            System.out.println("�ٸ�ȸ���� �̹� �뿩���� �����Դϴ�.");
                        }

                    } else if (kind == 3) {
                        System.out.println("������ �����ϼ̽��ϴ� å�Ǹ���� �����մϴ�");
                        for (String k : science) {
                            System.out.println(k);
                        }
                        System.out.println("�뿩�ϰ����ϴ� å�ǹ�ȣ�� �Է��ϼ���");
                        int booknum = scan.nextInt();
                        if (science[booknum - 1].length() == 4) {
                            System.out.println("�뿩������å�Դϴ�.");
                            if (memorial == 1) {
                                String bookna = science[booknum - 1];
                                cthbooklist.add(science[booknum - 1]);
                                science[booknum - 1] = bookna + "�뿩��";
                                System.out.println("�뿩�� ���������� �Ϸ��ϼ̽��ϴ�");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("�뿩 ���� ����:"+rentaldue);
                            } else if (memorial == 2) {
                                String bookna = science[booknum - 1];
                                lyjbooklist.add(science[booknum - 1]);
                                science[booknum - 1] = bookna + "�뿩��";
                                System.out.println("�뿩�� ���������� �Ϸ��ϼ̽��ϴ�");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("�뿩 ���� ����:"+rentaldue);
                            } else if (memorial == 3) {
                                String bookna = science[booknum - 1];
                                kybbooklist.add(science[booknum - 1]);
                                science[booknum - 1] = bookna + "�뿩��";
                                System.out.println("�뿩�� ���������� �Ϸ��ϼ̽��ϴ�");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("�뿩 ���� ����:"+rentaldue);
                            } else if (memorial == 4) {
                                String bookna = science[booknum - 1];
                                kyjbooklist.add(science[booknum - 1]);
                                science[booknum - 1] = bookna + "�뿩��";
                                System.out.println("�뿩�� ���������� �Ϸ��ϼ̽��ϴ�");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("�뿩 ���� ����:"+rentaldue);
                            }
                        } else {
                            System.out.println("�ٸ�ȸ���� �̹� �뿩���� �����Դϴ�.");
                        }
                    }

                    else if (kind == 4) {
                        System.out.println("������ �����ϼ̽��ϴ� å�Ǹ���� �����մϴ�");
                        for (String k : art) {
                            System.out.println(k);
                        }
                        System.out.println("�뿩�ϰ����ϴ� å�ǹ�ȣ�� �Է��ϼ���");
                        int booknum = scan.nextInt();

                        if (art[booknum - 1].length() == 4) {
                            System.out.println("�뿩������å�Դϴ�.");
                            if (memorial == 1) {
                                String bookna = art[booknum - 1];
                                cthbooklist.add(art[booknum - 1]);
                                art[booknum - 1] = bookna + "�뿩��";
                                System.out.println("�뿩�� ���������� �Ϸ��ϼ̽��ϴ�");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("�뿩 ���� ����:"+rentaldue);
                            } else if (memorial == 2) {
                                String bookna = art[booknum - 1];
                                lyjbooklist.add(art[booknum - 1]);
                                art[booknum - 1] = bookna + "�뿩��";
                                System.out.println("�뿩�� ���������� �Ϸ��ϼ̽��ϴ�");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("�뿩 ���� ����:"+rentaldue);
                            } else if (memorial == 3) {
                                String bookna = art[booknum - 1];
                                kybbooklist.add(art[booknum - 1]);
                                art[booknum - 1] = bookna + "�뿩��";
                                System.out.println("�뿩�� ���������� �Ϸ��ϼ̽��ϴ�");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("�뿩 ���� ����:"+rentaldue);
                            } else if (memorial == 4) {
                                String bookna = art[booknum - 1];
                                kyjbooklist.add(art[booknum - 1]);
                                art[booknum - 1] = bookna + "�뿩��";
                                System.out.println("�뿩�� ���������� �Ϸ��ϼ̽��ϴ�");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(rentalduedate);
                                cal.add(Calendar.DATE, 14);
                                rentaldue = timeformat.format(cal.getTime());
                                System.out.println("�뿩 ���� ����:"+rentaldue);
                            }
                        } else {
                            System.out.println("�ٸ�ȸ���� �̹� �뿩���� �����Դϴ�.");
                        }
                    }

                } else if (menu == 2) {
                    if (memorial == 1) {
                        System.out.println("�����ƴ��� �뿩��Ȳ");
                        for (int i = 0; i < cthbooklist.size(); i++) {
                            System.out.println((i + 1) + "��" + cthbooklist.get(i));
                        }
                        System.out.println("�ݳ��� å�� ��ȣ�� �Է����ּ��� ");
                        int returnbooknum = scan.nextInt();
                        if(cthbooklist.get(returnbooknum-1).charAt(0)=='��') {
                            String wantremovebook = cthbooklist.get(returnbooknum-1);
                            int befored = (int)cthbooklist.get(returnbooknum-1).charAt(3); 
                            humanities[befored-49] = wantremovebook;
                            cthbooklist.remove(returnbooknum - 1);
                            System.out.println("�ݳ��� ���������� �Ϸ��߽��ϴ�");
                        }else if(cthbooklist.get(returnbooknum-1).charAt(0)=='��') {
                            String wantremovebook = cthbooklist.get(returnbooknum-1);
                            int befored = (int)cthbooklist.get(returnbooknum-1).charAt(3); 
                            social[befored-49] = wantremovebook ;
                            cthbooklist.remove(returnbooknum - 1);
                            System.out.println("�ݳ��� ���������� �Ϸ��߽��ϴ�");
                        }else if(cthbooklist.get(returnbooknum-1).charAt(0)=='��') {
                            String wantremovebook = cthbooklist.get(returnbooknum-1);
                            int befored = (int)cthbooklist.get(returnbooknum-1).charAt(3); 
                            science[befored-49] = wantremovebook ;
                            cthbooklist.remove(returnbooknum - 1);
                            System.out.println("�ݳ��� ���������� �Ϸ��߽��ϴ�");
                        }else if(cthbooklist.get(returnbooknum-1).charAt(0)=='��') {
                            String wantremovebook = cthbooklist.get(returnbooknum-1);
                            int befored = (int)cthbooklist.get(returnbooknum-1).charAt(3); 
                            art[befored-49] = wantremovebook ;
                            cthbooklist.remove(returnbooknum - 1);
                            System.out.println("�ݳ��� ���������� �Ϸ��߽��ϴ�");
                        }
                        

                    } else if (memorial == 2) {
                        System.out.println("���������� �뿩��Ȳ");
                        for (int i = 0; i < lyjbooklist.size(); i++) {
                            System.out.println((i + 1) + "��" + lyjbooklist.get(i));
                        }
                        System.out.println("�ݳ��� å�� ��ȣ�� �Է����ּ��� ");
                        int returnbooknum = scan.nextInt();
                        if(lyjbooklist.get(returnbooknum-1).charAt(0)=='��') {
                            String wantremovebook = lyjbooklist.get(returnbooknum-1);
                            int befored = (int)lyjbooklist.get(returnbooknum-1).charAt(3); 
                            humanities[befored-49] = wantremovebook ;
                            lyjbooklist.remove(returnbooknum - 1);
                            System.out.println("�ݳ��� ���������� �Ϸ��߽��ϴ�");
                        }else if(lyjbooklist.get(returnbooknum-1).charAt(0)=='��') {
                            String wantremovebook = lyjbooklist.get(returnbooknum-1);
                            int befored = (int)lyjbooklist.get(returnbooknum-1).charAt(3); 
                            social[befored-49] = wantremovebook ;
                            lyjbooklist.remove(returnbooknum - 1);
                            System.out.println("�ݳ��� ���������� �Ϸ��߽��ϴ�");
                        }else if(lyjbooklist.get(returnbooknum-1).charAt(0)=='��') {
                            String wantremovebook = lyjbooklist.get(returnbooknum-1);
                            int befored = (int)lyjbooklist.get(returnbooknum-1).charAt(3); 
                            science[befored-49] = wantremovebook ;
                            lyjbooklist.remove(returnbooknum - 1);
                            System.out.println("�ݳ��� ���������� �Ϸ��߽��ϴ�");
                        }else if(lyjbooklist.get(returnbooknum-1).charAt(0)=='��') {
                            String wantremovebook = lyjbooklist.get(returnbooknum-1);
                            int befored = (int)lyjbooklist.get(returnbooknum-1).charAt(3); 
                            art[befored-49] = wantremovebook ;
                            lyjbooklist.remove(returnbooknum - 1);
                            System.out.println("�ݳ��� ���������� �Ϸ��߽��ϴ�");
                        }
                        
                    } else if (memorial == 3) {
                        System.out.println("��������� �뿩��Ȳ");
                        for (int i = 0; i < kybbooklist.size(); i++) {
                            System.out.println((i + 1) + "��" + kybbooklist.get(i));
                        }
                        System.out.println("�ݳ��� å�� ��ȣ�� �Է����ּ��� ");
                        int returnbooknum = scan.nextInt();
                        if(kybbooklist.get(returnbooknum-1).charAt(0)=='��') {
                            String wantremovebook = kybbooklist.get(returnbooknum-1);
                            int befored = (int)kybbooklist.get(returnbooknum-1).charAt(3); 
                            humanities[befored-49] = wantremovebook ;
                            kybbooklist.remove(returnbooknum - 1);
                            System.out.println("�ݳ��� ���������� �Ϸ��߽��ϴ�");
                        }else if(kybbooklist.get(returnbooknum-1).charAt(0)=='��') {
                            String wantremovebook = kybbooklist.get(returnbooknum-1);
                            int befored = (int)kybbooklist.get(returnbooknum-1).charAt(3); 
                            social[befored-49] = wantremovebook ;
                            kybbooklist.remove(returnbooknum - 1);
                            System.out.println("�ݳ��� ���������� �Ϸ��߽��ϴ�");
                        }else if(kybbooklist.get(returnbooknum-1).charAt(0)=='��') {
                            String wantremovebook = kybbooklist.get(returnbooknum-1);
                            int befored = (int)kybbooklist.get(returnbooknum-1).charAt(3); 
                            science[befored-49] = wantremovebook ;
                            kybbooklist.remove(returnbooknum - 1);
                            System.out.println("�ݳ��� ���������� �Ϸ��߽��ϴ�");
                        }else if(kybbooklist.get(returnbooknum-1).charAt(0)=='��') {
                            String wantremovebook = kybbooklist.get(returnbooknum-1);
                            int befored = (int)kybbooklist.get(returnbooknum-1).charAt(3); 
                            art[befored-49] = wantremovebook ;
                            kybbooklist.remove(returnbooknum - 1);
                            System.out.println("�ݳ��� ���������� �Ϸ��߽��ϴ�");
                        }
                    } else if (memorial == 4) {
                        System.out.println("�迵�ش��� �뿩��Ȳ");
                        for (int i = 0; i < kyjbooklist.size(); i++) {
                            System.out.println((i + 1) + "��" + kyjbooklist.get(i));
                        }
                        System.out.println("�ݳ��� å�� ��ȣ�� �Է����ּ��� ");
                        int returnbooknum = scan.nextInt();
                        if(kyjbooklist.get(returnbooknum-1).charAt(0)=='��') {
                            String wantremovebook = kyjbooklist.get(returnbooknum-1);
                            int befored = (int)kyjbooklist.get(returnbooknum-1).charAt(3); 
                            humanities[befored-49] = wantremovebook ;
                            kyjbooklist.remove(returnbooknum - 1);
                            System.out.println("�ݳ��� ���������� �Ϸ��߽��ϴ�");
                        }else if(kyjbooklist.get(returnbooknum-1).charAt(0)=='��') {
                            String wantremovebook = kyjbooklist.get(returnbooknum-1);
                            int befored = (int)kyjbooklist.get(returnbooknum-1).charAt(3); 
                            social[befored-49] = wantremovebook ;
                            kyjbooklist.remove(returnbooknum - 1);
                            System.out.println("�ݳ��� ���������� �Ϸ��߽��ϴ�");
                        }else if(kyjbooklist.get(returnbooknum-1).charAt(0)=='��') {
                            String wantremovebook = kyjbooklist.get(returnbooknum-1);
                            int befored = (int)kyjbooklist.get(returnbooknum-1).charAt(3); 
                            science[befored-49] = wantremovebook ;
                            kyjbooklist.remove(returnbooknum - 1);
                            System.out.println("�ݳ��� ���������� �Ϸ��߽��ϴ�");
                        }else if(kyjbooklist.get(returnbooknum-1).charAt(0)=='��') {
                            String wantremovebook = kyjbooklist.get(returnbooknum-1);
                            int befored = (int)kyjbooklist.get(returnbooknum-1).charAt(3); 
                            art[befored-49] = wantremovebook ;
                            kyjbooklist.remove(returnbooknum - 1);
                            System.out.println("�ݳ��� ���������� �Ϸ��߽��ϴ�");
                        }
                    }

                } else if (menu == 3) {
                    if (memorial == 1) {
                        System.out.println("�����ƴ��� �뿩��Ȳ");
                        for (int i = 0; i < cthbooklist.size(); i++) {
                            System.out.println((i + 1) + "��" + cthbooklist.get(i));
                        }
                    } else if (memorial == 2) {
                        System.out.println("���������� �뿩��Ȳ");
                        for (int i = 0; i < lyjbooklist.size(); i++) {
                            System.out.println((i + 1) + "��" + lyjbooklist.get(i));
                        }
                    } else if (memorial == 3) {
                        System.out.println("��������� �뿩��Ȳ");
                        for (int i = 0; i < kybbooklist.size(); i++) {
                            System.out.println((i + 1) + "��" + kybbooklist.get(i));
                        }
                    } else if (memorial == 4) {
                        System.out.println("�迵�ش��� �뿩��Ȳ");
                        for (int i = 0; i < kyjbooklist.size(); i++) {
                            System.out.println((i + 1) + "��" + kyjbooklist.get(i));
                        }
                    }

                } else if (menu == 4) {
                    endminer = false;
                } else if (menu == 5) {
                    endminer = false;
                    allrepeater =false;

                }

            }
        }
    }
}
