package com.wskh.DataStructures.LinkedList;

/**
 * @Author：WSKH
 * @ClassName：SingleLinkedList
 * @ClassType：
 * @Description：
 * @Date：2022/12/3/20:24
 * @Email：1187560563@qq.com
 * @Blog：https://blog.csdn.net/weixin_51545953?type=blog
 */
public class SingleLinkedList {
    public static void main(String[] args) {
        // 进行测试
        // 创建单链表对象
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        // 增加节点
        System.out.println("增加节点：");
        singleLinkedList.add(new HeroNode("wskh"));
        singleLinkedList.add(new HeroNode("lso"));
        singleLinkedList.add(new HeroNode("wrq"));
        singleLinkedList.add(new HeroNode("sxc"));
        singleLinkedList.list();
        // 删除节点
        System.out.println("删除节点：");
        singleLinkedList.remove("wrq");
        singleLinkedList.remove("sxc");
        singleLinkedList.list();
    }

    // 当前节点的英雄
    HeroNode heroNode;
    // 子节点
    SingleLinkedList next;

    // 添加节点
    public void add(HeroNode heroNode){
        if(this.heroNode == null){
            this.heroNode = heroNode;
            next = new SingleLinkedList();
        }else{
            next.add(heroNode);
        }
    }

    // 根据名字删除节点
    public void remove(String name){
        if(heroNode != null && name.equals(heroNode.name)){
            if(next != null){
                heroNode = next.heroNode;
                next = next.next;
            }else{
                heroNode = null;
            }
        }else if(next != null){
            next.remove(name);
        }
    }

    // 输出链表中所有的英雄节点信息
    public void list() {
        if (this.heroNode != null) {
            System.out.println(heroNode.name);
            if (this.next != null) {
                next.list();
            }
        }
    }

    // 英雄节点类
    static class HeroNode {
        String name;

        public HeroNode(String name) {
            this.name = name;
        }
    }

}
