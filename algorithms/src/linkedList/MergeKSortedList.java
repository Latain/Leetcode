package linkedList;

public class MergeKSortedList {
	
	private class ListNode{
		public int val;
		public ListNode next;
		public ListNode(int val){
			this.val=val;
		}
	}
	
	public ListNode mergeKLists(ListNode[] lists){
		if(lists==null || lists.length==0)
			return null;
		return mergeHelper(lists,0,lists.length-1);
	}
	
	public ListNode mergeHelper(ListNode[] lists,int start,int end){
		if(start<end){
			int middle=(start+end)/2;
			return merge(mergeHelper(lists,start,middle),mergeHelper(lists,middle+1,end));
		}
		return lists[start];
	}
	
	public ListNode merge(ListNode list1,ListNode list2){
		ListNode head=new ListNode(0);
		head.next=list1;
		ListNode trackNode=head;
		
		while(list1!=null && list2!=null){
			if(list1.val>list2.val){
				ListNode newNode=list2.next;
				trackNode.next=list2;
				list2.next=list1;
				list2=newNode;
			}else{
				list1=list1.next;
			}
			trackNode=trackNode.next;
		}
		
		if(list2!=null){
			trackNode.next=list2;
		}
		return head.next;
	}
}
