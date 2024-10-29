class ListNode {
    int value; // The value of the node
    ListNode next; // Pointer to the next node

    ListNode(int value) {
        this.value = value; // Constructor to initialize the node's value
        this.next = null; // Initialize next to null
    }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // Dummy node to simplify result list creation
        ListNode current = dummyHead; // Pointer to build the new list
        int carry = 0; // Initialize carry to 0

        // Traverse both lists
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry; // Start with the carry

            // Add the value from the first list if available
            if (l1 != null) {
                sum += l1.value; // Access the value of the current node in l1
                l1 = l1.next; // Move to the next node
            }

            // Add the value from the second list if available
            if (l2 != null) {
                sum += l2.value; // Access the value of the current node in l2
                l2 = l2.next; // Move to the next node
            }

            // Create a new node with the digit value (sum % 10)
            current.next = new ListNode(sum % 10);
            current = current.next; // Move to the next node in the result list
            carry = sum / 10; // Update carry for the next iteration
        }

        return dummyHead.next; // Return the next node of dummy head, which is the actual head of the result list
    }

    public static void main(String[] args) {
        // Create first linked list: 2 -> 4 -> 3 (represents the number 342)
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Create second linked list: 5 -> 6 -> 4 (represents the number 465)
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumbers adder = new AddTwoNumbers();
        ListNode result = adder.addTwoNumbers(l1, l2);

        // Print the resulting linked list
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
