package com.huanletao.huanletao.observer.base;

import com.huanletao.huanletao.observer.api.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2020/10/20
 * @Time: 21:12
 * Description: 观察主题。
 */
public abstract class AbstractSubject {
    //观察者队列。
    private List<Observer> observers = new ArrayList<>();

    //注册一个观察者
    public void registerObserver(Observer observer){
        observers.add(observer);
    }

    //移除一个观察者
    void removeObserver(Observer observer){
        observers.remove(observer);
    };

    //处理通知。
    protected void notifyObserver(Map<String,String> map){
        for (Observer observer : observers) {
            observer.sendNotice(map);
        }
    }

}
