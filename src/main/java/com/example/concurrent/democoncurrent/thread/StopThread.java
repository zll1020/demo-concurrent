package com.example.concurrent.democoncurrent.thread;
public class StopThread extends Thread {
  private int i = 0, j = 0;

  @Override
  public void run() {
    synchronized (this) {
	    // ����ͬ������ȷ���̰߳�ȫ
	    ++i;
	    try {
	      // ����10��,ģ���ʱ����
	      Thread.sleep(10000);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
	    ++j;
    }
  }

  /** * ��ӡi��j */
  public void print() {
  System.out.println("i=" + i + " j=" + j);
  }
}