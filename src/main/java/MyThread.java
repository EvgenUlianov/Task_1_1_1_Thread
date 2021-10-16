class MyThread extends Thread implements Runnable{

    public MyThread(ThreadGroup group) {
        super(group, currentThread());
    }

    @Override
    public void run() {
        final int timeOut15 = 15_000;
        final int timeOut = 2500;
        String currentName = super.getName();
        ThreadsBuffer buffer = ThreadsBuffer.get();

        try {
            while(!isInterrupted()) {
                Thread.sleep(timeOut);
                System.out.printf("Я поток %s. Всем привет!\n", currentName);
                if (buffer.getSleepComand(currentName)){
                    synchronized (buffer) {
                        // мы этот момент еще не изучали, но судя по всему, правильно делать именно так
                        if (buffer.getSleepComand(currentName)){
                            System.out.printf("Я поток %s. Я ложусь спать!\n", currentName);
                            buffer.setSleepComand(currentName, false);
                                Thread.sleep(timeOut15);
                                System.out.printf("Я поток %s. Я долго спал!\n", currentName);
                            }
                        }
                    }
                }
        } catch (InterruptedException e) {
            //e.printStackTrace();
        } finally{
            System.out.printf("%s завершен\n", getName());
        }
    }
}
