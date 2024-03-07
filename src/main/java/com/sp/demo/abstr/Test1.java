package com.sp.demo.abstr;

import com.sp.demo.MyTask;
import com.sp.demo.dto.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/2/23 17:11
 */
public class Test1 {
    public void test1(Bird bird){
        System.out.println(bird.getName() + "飞" + bird.fly() + "米");
    }

    class Inner{}

    public void bar(){
        new Inner();
    }

    private Lock lock = new ReentrantLock();

    public void start(){
        lock.lock();
        List<Person> sortList = new ArrayList<Person>();
        Collections.sort(sortList);
        lock.unlock();
    }

    public static void main(String[] args) throws Exception {

        List<Future<Integer>> list = new ArrayList<Future<Integer>>();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            list.add(executorService.submit(new MyTask((int) (Math.random() *100))));
        }

        int sum = 0;
        for (Future<Integer> future : list){
            sum += future.get();
        }
        System.out.println(sum);
//        executorService.shutdown();
        
//        List<Object> list = Collections.synchronizedList(new ArrayList<Object>());
//            try{
//                try{
//                    throw new Sneeze();
//                }
//                catch(Annoyance a){
//                    System.out.println("CaughtAnnoyance");
//                    throw a;
//                }
//            }
//            catch(Sneeze s){
//                System.out.println("CaughtSneeze");
//                return;
//            }
//            finally{
//                System.out.println("HelloWorld!");
//            }


//        Test1 test1 = new Test1();
//        test1.test1(new Bird() {
//            @Override
//            public int fly() {
//                return 1000;
//            }
//
//            @Override
//            public String getName() {
//                return "家禽";
//            }
//        });
    }

}

class Annoyance extends Exception{}
class Sneeze extends Annoyance{}
