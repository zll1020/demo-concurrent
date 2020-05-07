package com.example.concurrent.democoncurrent.thread;

/**
 * ʾ��3 - �߳�stopǿ������ֹ���ƻ��̰߳�ȫ��ʾ��
 */
public class Demo3 {
  public static void main(String[] args) throws InterruptedException {
    StopThread thread = new StopThread();
    thread.start();
    // ����1�룬ȷ��i���������ɹ�
    Thread.sleep(1000);
    // ��ͣ�߳�
   //  thread.stop(); // �������ֹ
   thread.interrupt(); // ��ȷ��ֹ
    while (thread.isAlive()) {
      // ȷ���߳��Ѿ���ֹ
    } // ������
    thread.print();
  }
}
