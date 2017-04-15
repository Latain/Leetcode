package linkedList;

import java.util.List;
import java.util.ArrayList;

public class ReverseLinkedList {
	private ListNode headNode;
	private ListNode markNode;
	
	public ReverseLinkedList(int[] nums){
		for(int i=0;i<nums.length;i++){
			ListNode newNode=new ListNode(nums[i]);
			if(i==0){
				headNode=markNode=newNode;
			}else{
				markNode.next=newNode;
				markNode=markNode.next;
			}
		}
	}
	
	public ListNode getHeadNode(){
		return headNode;
	}
	
	public class ListNode{
		public int val;
		public ListNode next;
		public ListNode(int val){
			this.val=val;
		}
	}
	
	public ListNode reverseBetween(ListNode head,int m,int n){
		if(head==null)
			return null;
		if(m>n)
			return reverseBetween(head,n,m);
		ListNode copyNode=head;
		ListNode beforeM=null;
		ListNode afterN=null;
	    List<ListNode> list=new ArrayList<ListNode>();
	    int index=0;
	    int i=0;
	    while(copyNode!=null){
	    	index++;
	    	if(copyNode.next==null && index<=m)
	    		return head;
	    	if(index==m-1)
	    		beforeM=copyNode;
	    	if(index>=m && index<=n){
	    		list.add(copyNode);
	    		if(index==n)
	    			afterN=copyNode.next;
	    		i++;
	    	}
	    	copyNode=copyNode.next;
	    }
	    
	    int right=list.size()-1;
	    if(beforeM!=null)
	    	beforeM.next=list.get(right);
	    else
	    	head=list.get(right);
	    list.get(0).next=afterN;
	    while(right>0){
	    	list.get(right).next=list.get(right-1);
	    	right--;
	    }
		
		return head;
	}
	
	public static void main(String[] args){
		int[] nums=new int[]{3,5};
		ReverseLinkedList reverse=new ReverseLinkedList(nums);
		ListNode head=reverse.reverseBetween(reverse.getHeadNode(),1,2);
		while(head!=null){
			System.out.print(head.val+" ");
			head=head.next;
		}
	}
}
