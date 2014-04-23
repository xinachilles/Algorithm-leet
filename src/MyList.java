
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yangfeng
 */
class MyNode
    {
        public Integer Value;
        public MyNode Next;
        public MyNode() { }
        public MyNode(int value)
        {
            Value = value;
            Next = null;
        }


    }

public class MyList {
        public MyNode head =null;
        public int get(int index)
        {
            
                Integer [] arrResult = TravelList();
                return arrResult[index];


        }
       public void set(int index,int value)
       {
                MyNode temp = head;
                int i = 0;
                while (temp.Next != null)
                {
                    if (i == index)
                    {
                        break;
                    }
                    else
                    {
                        temp = temp.Next;
                        i++;

                    }
                    if (i == index)
                    {
                        temp.Value = value;
                    }
                }

    }

        
               public MyList(int[] n)
            {

                for( int item: n)
                {
                    AppendToTaile(item);
                }
            }
           



            // return the node which its next node contrain the 'data'
            private MyNode TravelList(int data)
            {
                MyNode temp = head;
                while (temp.Next != null)
                {
                    if (temp.Next.Value == data)
                    {
                        return temp;

                    }
                    else
                    {
                        temp = temp.Next;
                    }
                }
                return null;
            }

            




        public MyNode FindBeginning()
            {
                MyNode slow = head;
                MyNode fast = head;

                /* Find meeting point. This will be LOOP_SIZE - k steps into the
                 * linked list. */
                while (fast != null && fast.Next != null)
                {
                    slow = slow.Next;
                    fast = fast.Next.Next;
                    if (slow == fast)
                    { // Collision
                        break;
                    }
                }

                /* Error check - no meeting point, and therefore no loop */
                if (fast == null || fast.Next == null)
                {
                    return null;
                }

                /* Move slow to Head. Keep fast at Meeting Point. Each are k
                * steps from the Loop Start. If they move at the same pace,
                * they must meet at Loop Start. */
                slow = head;
                while (slow != fast)
                {
                    slow = slow.Next;
                    fast = fast.Next;
                }

                /* Both now point to the start of the loop. */
                return fast;
            }

        public int length(MyNode node)
            {
                int i = 0;
                while (node != null)
                {
                    node = node.Next;
                    i = i + 1;
                }
                return i;
            }
        
        private void MyDeleteList(int data)
        {
            // if the head contain the data, delete the head
            if (head.Value == data)
            {
                head = head.Next;

            }
            else
            {
                MyNode d_node = TravelList(data);
                if (d_node != null)
                {
                    d_node.Next = d_node.Next.Next;

                }

            }

        }

        private void AppendToTaile(int d)
        {

            // if n is head
            if (head == null)
            {
                head = new MyNode();
                head.Value = d;
            }
            else
            {
                MyNode temp = head;
                MyNode end = new MyNode();
                end.Value = d;
                while (temp.Next != null)
                {
                    temp = temp.Next;
                }
                temp.Next = end;
                end.Next = null;

            }
        }

        public Integer[] TravelList()
        {

            List< Integer> n = new ArrayList<>();
            MyNode temp = head;
            // n.Clear();
            while (temp != null)
            {
                n.add(temp.Value);
                temp = temp.Next;

            }

            return n.toArray(new Integer[n.size()]);

        }

        public Integer[] TravelList(MyNode node)
        {

            List<Integer> n = new ArrayList<Integer>();
            MyNode temp = node;
            // n.Clear();
            while (temp != null)
            {
                n.add(temp.Value);
                temp = temp.Next;

            }

            return n.toArray(new Integer[n.size()]);

        }

        
        //Write code to partition a linked list around a value x, such that all nodes less than x
        //come before all nodes greater than or equal to x.
        public MyNode Partition(int x)
        {
            MyNode beforeStart = null;
            MyNode beforeEnd = null;
            MyNode afterStart = null;
            MyNode afterEnd = null;
            MyNode node = head;

            while (node != null)
            {


                if (node.Value <= x)
                {

                    if (beforeStart == null)
                    {

                        beforeStart = node;
                        beforeEnd = beforeStart;
                    }
                    else
                    {
                        beforeEnd.Next = node;
                        beforeEnd = node;

                    }

                }

                else
                {
                    if (afterStart == null)
                    {
                        afterStart = node;
                        afterEnd = afterStart;
                    }
                    else
                    {
                        afterEnd.Next = node;
                        afterEnd = node;

                    }

                }

                node = node.Next;

            }

            if (beforeStart != null)
            {
                beforeEnd.Next = afterStart;
                afterEnd.Next = null;
                return beforeStart;
            }
            else
            {
                afterEnd.Next = null;
                return afterStart;

            }
        }
        // only use two variable
        public MyNode Partition2(int x)
        {

            MyNode node = head;
            MyNode beforeStart = null;
            MyNode afterStart = null;

            /* Partition list */
            while (node != null)
            {
                MyNode next = node.Next;
                if (node.Value < x)
                {
                    /* Insert node into start of before list */
                    node.Next = beforeStart;
                    beforeStart = node;
                }
                else
                {
                    /* Insert node into front of after list */
                    node.Next = afterStart;
                    afterStart = node;
                }
                node = node.Next;
            }

            /* Merge before list and after list */
            if (beforeStart == null)
            {
                return afterStart;
            }

            /* Find end of before list, and merge the lists */
            MyNode before_head = beforeStart;
            while (beforeStart.Next != null)
            {
                beforeStart = beforeStart.Next;
            }
            beforeStart.Next = afterStart;

            return before_head;
        }


       


        public boolean DeleteNode(MyNode n)
        {
            if (n == null || n.Next == null)
            {
                return false; // Failure
            }
            MyNode next = n.Next;
            n.Value = next.Value;
            n.Next = next.Next;
            return true;
        }

        //public void DeleteList(ref MyNode node)
        //{

        //    if (node != null && node.next != null)
        //    {

        //        MyNode temp = node;
        //        MyNode perious = null;
        //        while (temp.next != null)
        //        {
        //            temp.data = temp.next.data;
        //            perious = temp;
        //            temp = temp.next;

        //        }
        //        if (perious != null) perious.next = null;

        //    }

        //    if (node != null && node.next == null)
        //    {

        //        node = null;

        //    }


        //}
        
      public void MergeSort(int begin, int end, MyNode n)
      {
          int mid = (begin+end) /2 ;
          MergeSort(begin,mid,n);
          MergeSort(mid+1,end,n);
          Merge(begin,mid, end, n);
      }
      
      public void Merge(int begin,int mid, int end, MyNode n)
      {
          int n1 = mid-begin +1; 
          int n2 = end-mid;
          
          int[] a1 = new int[n1];
          int[] a2 = new int[n2];
          
          for (int i = 0; i < n1; i++) {
              a1[i] = n.Value;
              n= n.Next;
          }
          
          for (int i = 0; i < n2; i++) {
              a2[i] = n.Value;
              n = n.Next;
          }
          
          int k =0 ; // for n1
          int j = 0; // for n2
          
          for (int i = begin; i <= end; i++) {
              if(k>= n1){
                 this.set(i, a2[j]);
                      
                  
              }
              
          }
      }
        
    }
    

