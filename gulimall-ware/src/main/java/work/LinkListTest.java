package work;

public class LinkListTest {

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        LinkListUtils.initLinkList(linkList);
        LinkListUtils.addLinkList(linkList,1);
        LinkListUtils.addLinkList(linkList,3);
        LinkListUtils.addLinkList(linkList,5);
        LinkListUtils.addLinkList(linkList,7);
        LinkList headList = linkList;
        System.out.println("初始化，并且添加4个节点，此时List的值为：");
        while ((linkList = linkList.getNext()).getNext() != null){
            System.out.print(linkList.getValue() + ", ");
        }
        linkList = headList;
        LinkListUtils.insertLinkList(linkList,2,4);
        System.out.println();
        System.out.println("在第二个有值的节点后添加一个value为4的节点，此时List的值为：");
        while ((linkList = linkList.getNext()).getNext() != null){
            System.out.print(linkList.getValue() + ", ");
        }
        linkList = headList;
        LinkListUtils.deleteLinkList(linkList,2);
        System.out.println();
        System.out.println("删除第二个有值的节点，此时List的值为：");
        while ((linkList = linkList.getNext()).getNext() != null){
            System.out.print(linkList.getValue() + ", ");
        }

    }

}
