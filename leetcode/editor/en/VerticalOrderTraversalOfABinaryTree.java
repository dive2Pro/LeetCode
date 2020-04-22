//Given a binary tree, return the vertical order traversal of its nodes values. 
//
//
// For each node at position (X, Y), its left and right children respectively wi
//ll be at positions (X-1, Y-1) and (X+1, Y-1). 
//
// Running a vertical line from X = -infinity to X = +infinity, whenever the ver
//tical line touches some nodes, we report the values of the nodes in order from t
//op to bottom (decreasing Y coordinates). 
//
// If two nodes have the same position, then the value of the node that is repor
//ted first is the value that is smaller. 
//
// Return an list of non-empty reports in order of X coordinate. Every report wi
//ll have a list of values of nodes. 
//
// 
//
// Example 1: 
//
// 
//
// 
// 
//Input: [3,9,20,null,null,15,7]
//Output: [[9],[3,15],[20],[7]]
//Explanation: 
//Without loss of generality, we can assume the root node is at position (0, 0):
//
//Then, the node with value 9 occurs at position (-1, -1);
//The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
//The node with value 20 occurs at position (1, -1);
//The node with value 7 occurs at position (2, -2).
// 
//
// 
// Example 2: 
//
// 
//
// 
//Input: [1,2,3,4,5,6,7]
//Output: [[4],[2],[1,5,6],[3],[7]]
//Explanation: 
//The node with value 5 and the node with value 6 have the same position accordi
//ng to the given scheme.
//However, in the report "[1,5,6]", the node value of 5 comes first since 5 is s
//maller than 6.
// 
//
// 
// 
//
// Note: 
//
// 
// The tree will have between 1 and 1000 nodes. 
// Each node's value will be between 0 and 1000. 
// 
// 
//
// 
// 
// 
// Related Topics Hash Table Tree


package leetcode.editor.en;

import java.util.*;

public class VerticalOrderTraversalOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new VerticalOrderTraversalOfABinaryTree().new Solution();
//        solution.verticalTraversal(TreeNode.generateFrom(new Object[]{
////                3, 9, 20, null, null, 15, 7
//                0, 1, 2, 17, 16, 3, 5, 86, 23, 70, 137, 4, 8, 31, 6, 419, 120
//                , 76, 61, 409, 121, 231, 188, 7, 10, 9, 11, 72, 49, 33, 60,
//                null, null, 427, 122, 180, 101, 68, 67, 654, null, 123, null,
//                563, null, 462, 397, 34, 15, 12, 24, 30, 147, 20, 13, 107, 85
//                , 166, 90, 703, 81, 74, 95, null, 746, null, 128, 311, null,
//                160, null, 346, 185, 265, 547, null, null, null, 138, 715,
//                null, null, 964, null, 870, 69, 405, 18, 27, 14, 37, 113, 29,
//                196, 89, 170, 175, 88, 25, 38, 21, 131, 189, 329, 171, null,
//                967, 103, 362, null, 737, 239, 217, 77, 443, 455, 204, null,
//                984, 686, 241, 524, 347, 893, 278, 980, 904, 190, 315, null,
//                null, 897, 934, 256, 155, 992, null, null, 975, null, 888,
//                109, 97, null, 582, 22, 19, 40, 44, 26, 56, 532, 52, null,
//                854, 43, 36, null, 489, 313, 172, 225, 176, 542, 305, 195,
//                754, 65, 32, 39, 41, 28, 45, 164, null, 621, 385, 693, 790,
//                null, 220, null, null, 222, 139, 515, 371, null, null, 914,
//                null, 238, 292, 132, 377, 710, 648, 502, null, 274, null,
//                null, null, null, null, 300, 500, 649, null, 444, null, null,
//                null, 420, 288, null, null, null, 998, null, null, 951, null,
//                null, null, null, 935, 360, null, 451, 560, null, null, null,
//                null, null, null, 290, 130, 337, null, null, null, 42, null,
//                35, 111, 91, 242, 54, 323, 51, 248, 93, 273, null, null, 105,
//                80, 944, null, 83, 236, 55, 58, 522, null, 700, 426, 508, 194
//                , 294, 259, 487, 551, 594, null, 425, null, 224, 679, 766,
//                981, 73, 163, 75, 50, 227, 66, 48, 356, 46, 228, 53, 63, 243,
//                424, null, 850, 653, null, null, null, null, null, null, 235,
//                null, 666, 286, 191, 908, 548, 410, 680, null, null, null,
//                285, 891, 333, 694, 492, 388, 550, null, null, null, 664,
//                null, null, 428, null, 433, 846, null, null, 787, null, null,
//                713, null, 544, 486, 289, null, null, 961, null, null, null,
//                716, 501, null, 730, null, null, 458, 317, 885, 178, null,
//                363, null, 325, 149, 59, 173, null, 266, 108, 697, null, 64,
//                57, 340, null, 96, 119, 422, null, 267, 125, null, 435, 447,
//                361, 844, 94, null, null, 280, 299, 270, 644, 124, 99, 226,
//                293, 794, null, null, 836, 457, 576, null, null, null, 603,
//                626, 411, null, null, 822, 556, 997, null, 732, null, 615,
//                null, null, 446, null, 847, null, null, null, null, null, 373
//                , 199, 263, 135, 84, 148, 150, 595, 768, 162, 158, 622, 209,
//                374, 465, 403, 47, 309, 318, 252, 296, 98, 82, null, 253,
//                null, null, null, null, 815, 656, 295, 378, 704, 867, 521,
//                null, 214, 393, null, 927, 593, null, 474, null, null, 777,
//                null, 431, null, 994, 877, null, null, null, null, null, 583,
//                635, 855, 639, 809, 920, 538, 695, null, 505, null, null,
//                null, null, null, null, 824, 698, null, 513, null, null, null
//                , null, null, null, 873, 950, null, null, 647, null, null,
//                null, null, 987, 179, null, null, 407, null, 415, 186, 154,
//                78, 611, 174, 203, null, 358, null, null, null, null, 71, 117
//                , 271, 62, null, null, 412, 112, 283, 351, null, 430, null,
//                442, 906, 260, 866, null, 629, 520, 413, 386, null, null, 114
//                , 100, 663, null, 773, 456, 277, 389, null, null, null, 127,
//                129, 572, null, null, 707, null, null, null, 890, null, null,
//                null, null, null, null, 701, null, null, 860, 558, null, null
//                , null, null, null, null, null, null, null, null, 600, null,
//                861, null, 398, 810, 230, 208, 943, 960, 212, 156, 87, 338,
//                152, null, 168, 193, null, 617, null, null, 806, 382, 237,
//                null, null, null, 218, 350, 471, 400, 466, 476, null, 587,
//                245, 92, 344, 637, null, null, null, 735, 367, 341, 118, null
//                , 250, 141, 569, null, 921, null, null, null, 507, 623, null,
//                661, 724, null, null, null, 523, 734, 221, 434, 643, null,
//                null, null, null, 764, 504, null, null, null, 517, 742, null,
//                null, null, 881, 892, 886, 965, null, null, null, 840, 919,
//                null, null, null, null, null, null, 783, 878, 757, null, null
//                , null, null, 739, null, 832, null, null, null, null, null,
//                null, null, null, 215, 187, null, 408, 692, null, 268, null,
//                379, 596, 110, 104, 628, 657, 244, null, 232, 303, null, 630,
//                696, 126, 192, null, null, 554, 79, 165, 472, null, null, 453
//                , 380, null, 761, null, null, 591, null, 640, null, null, 481
//                , 738, null, null, null, null, 750, 896, 668, 485, null, 801,
//                159, 368, 206, 102, 670, null, 969, null, 658, 613, 324, 354,
//                null, 404, 133, 144, null, 169, 624, null, null, null, null,
//                null, null, null, null, null, 770, 722, null, 798, null, null
//                , 483, null, null, null, 606, 604, 352, 281, 953, null, 962,
//                null, 573, 316, 200, 161, 115, 106, null, null, 381, 401,
//                null, null, 396, 205, 864, 638, null, 966, 488, 480, 275, 851
//                , 475, 370, 436, null, 818, 510, 762, 449, null, null, 512,
//                null, null, null, 357, null, null, 392, null, 659, 905, null,
//                null, null, 390, 383, null, 417, 752, 837, null, 467, 247,
//                327, 612, 645, null, 947, 616, null, null, 651, null, null,
//                null, null, null, null, null, null, 349, 423, null, 530, null
//                , null, null, null, null, 740, 527, 685, null, null, null,
//                null, null, null, null, null, null, null, null, null, null,
//                933, null, null, null, null, null, null, 858, 949, null, null
//                , null, 394, null, 366, 494, 667, null, 915, null, 298, 642,
//                null, 853, null, 145, 142, 153, null, null, null, null, 989,
//                257, null, 499, null, 402, 503, null, null, 776, null, 177,
//                134, 198, null, null, 636, 332, 143, null, 395, 857, 996,
//                null, null, 634, null, null, null, null, null, 753, null, 669
//                , 743, 765, null, null, 772, null, null, null, null, null,
//                null, 952, 863, null, 181, 598, 677, 331, 498, 249, 116, 789,
//                null, null, null, 879, null, null, null, 490, 364, null, null
//                , 646, null, null, 157, 774, null, 631, 948, 714, null, null,
//                null, null, 775, null, null, null, 546, null, null, null, 727
//                , null, 571, null, 310, null, null, null, null, null, null,
//                null, 319, 262, 240, 182, null, 304, 136, 321, 229, null,
//                null, 439, null, 584, null, 531, 687, null, null, null, null,
//                null, null, null, null, null, null, 291, 437, null, 917, 570,
//                932, null, null, null, 495, null, null, null, 525, null, null
//                , null, null, null, null, 461, null, null, null, null, null,
//                null, null, null, 963, 536, 454, 493, 553, null, null, null,
//                null, null, 588, null, 255, null, 865, 725, 834, null, null, null, null, 691, null, null, null, 574, 748, 452, 652, 566, null, 786, null, null, 814, null, null, null, null, null, null, null, 999, null, null, 552, 838, null, 518, null, 792, null, null, 375, 516, null, null, 938, null, 146, 151, 264, 284, 348, 597, null, null, 372, 406, 780, 509, 421, null, 672, null, 839, 889, 322, 706, 210, 862, null, 301, 956, 711, null, 468, 414, 287, null, 589, null, null, null, null, null, null, 812, null, null, null, null, 856, null, 941, 926, null, null, null, 936, null, 211, 585, null, null, null, 747, 545, 990, 741, null, 306, null, 167, null, null, null, null, null, 782, null, 478, null, null, 705, 201, 184, null, null, 795, 983, null, null, null, 911, null, null, null, 986, null, null, null, null, 445, null, 482, 682, null, null, 736, 539, 233, null, null, 688, 202, 140, 662, 391, 609, 308, null, 440, 928, 599, 909, 614, null, null, null, null, 660, null, null, null, null, 788, null, null, null, null, null, 760, null, null, null, null, 541, 871, 868, 610, 883, 549, 731, null, null, null, 448, 258, null, null, null, 929, null, null, 923, null, 728, 655, null, null, null, 469, null, 719, 827, null, 841, null, null, null, null, null, 608, 577, null, 852, 902, 561, null, 946, 759, 526, 535, null, null, null, 302, 213, null, 353, null, null, 807, 602, 429, null, null, 804, 726, null, null, 533, null, null, null, 564, null, 937, 825, null, null, null, null, null, null, null, null, null, 328, 219, null, null, null, 464, null, null, null, null, null, null, null, 441, 432, 355, 912, 848, null, 913, null, null, null, null, null, null, null, null, 216, 307, null, null, null, null, 931, 605, null, null, null, null, 387, 326, 183, 579, null, null, null, 675, null, 918, 207, 339, null, 251, null, 869, null, null, null, null, null, null, 537, 534, null, 985, null, null, 803, null, null, 562, null, 254, null, null, 477, 314, 197, 234, 901, 671, null, 650, 959, null, 601, 384, 580, null, null, null, null, null, null, null, 995, 957, 916, 756, 972, 835, 791, null, 973, 575, null, null, null, 982, 793, 821, 968, null, 717, null, null, null, 875, 543, 343, 297, null, null, null, null, null, null, null, null, null, null, 829, null, null, null, null, null, null, 882, null, null, null, null, null, null, null, 745, null, null, null, 826, null, 528, 842, null, 633, 514, 261, 279, 620, 799, null, null, 718, 991, 506, 540, null, null, null, 751, 778, null, null, null, null, null, 942, null, null, 511, 880, 276, 993, null, 459, 450, null, null, null, null, null, null, null, null, null, null, null, 269, 828, 336, null, null, null, null, 689, 460, 733, null, 330, 246, 619, null, null, 699, null, null, 976, 223, 365, 708, 484, null, null, null, 808, null, 586, 557, null, null, null, null, 678, 955, 876, 282, null, 632, null, 491, 335, 376, 690, 592, null, null, 811, 683, null, null, null, null, null, 641, 899, 555, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 874, null, 977, null, null, null, null, null, null, 823, null, 805, null, 320, null, null, null, null, null, null, null, null, null, 673, null, null, 907, null, 771, 849, 519, 418, 479, null, 342, null, 872, null, null, null, 830, null, null, 559, null, 922, null, 859, null, null, 924, null, null, 945, null, null, null, 470, null, null, null, null, 618, null, null, 463, null, null, null, null, null, null, 988, null, 744, null, null, 581, null, 590, 272, null, 763, 958, null, null, null, 723, 345, 496, 416, 813, null, 755, 940, null, null, null, null, 767, 578, 819, 684, null, null, null, null, 312, 334, null, null, null, 970, 369, 359, 473, 843, null, null, 720, null, 816, 831, 954, 709, 779, 681, null, null, 895, 674, null, null, null, null, null, null, 898, null, null, 820, null, 903, null, 910, null, null, null, null, null, 565, 769, null, null, null, null, 625, null, null, null, null, null, null, null, 925, null, null, null, null, null, null, 665, 676, null, null, 894, null, null, null, null, null, null, null, null, 729, null, 399, 802, null, null, null, 887, null, null, null, null, 758, null, null, null, 979, 884, 797, null, null, null, null, 721, null, null, null, null, null, null, 702, 781, 438, null, null, null, 497, null, 749, 712, 529, 845, null, 974, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 978, null, null, null, 971, null, null, null, 607, null, 817, 785, 796, null, null, null, null, null, null, null, null, null, null, null, 567, null, null, 930, null, null, null, null, null, null, null, null, null, null, null, null, null, 784, null, null, 568, 627, null, null, null, null, null, null, 800, null, null, null, null, null, null, null, null, null, null, null, null, 900, null, null, null, null, 833, null, null, 939
//        }));
        solution.verticalTraversal(TreeNode.generateFrom(new Object[]{
            3, 9, 20, null, null, 15, 7
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        int leftest = 0;

        List<Integer> sort(List<Integer> list) {
            list.sort((Integer x, Integer y) -> {
                return x - y;
            });
            return list;
        }

        public List<List<Integer>> verticalTraversal2(TreeNode root) {
            Map<Integer, Map<Integer, List<Integer>>> map = new HashMap<>();
            dfs(root, map, 0, 0);
            List<List<Integer>> list = new ArrayList<>();

            for (int i = 0; i < map.size(); i++) {
                Map<Integer, List<Integer>> currMap = map.get(leftest++);
                Iterator<List<Integer>> values = currMap.values().iterator();
                List<Integer> next = new ArrayList<>();
                while (values.hasNext()) {
                    next.addAll(sort(values.next()));
                }
                list.add(next);
            }

            return list;
        }

        private void dfs(TreeNode root, Map<Integer, Map<Integer,
                List<Integer>>> map, int x, int y) {
            if (root == null) return;

            if (leftest > x) {
                leftest = x;
            }

            map.putIfAbsent(x, new TreeMap<>()); // TODO: 优化掉 TreeMap
            map.get(x).putIfAbsent(y, new ArrayList<>());
            map.get(x).get(y).add(root.val);

            dfs(root.left, map, x - 1, y + 1);
            dfs(root.right, map, x + 1, y + 1);
        }

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            Map<Integer, List<List<Integer>>> map = new HashMap<>();
            int[] minMax = new int[]{0, 0};
            processOn(root, map, 0, 0, minMax);
            List<List<Integer>> list = new ArrayList<>();

            for (int i = 0; i <= minMax[1] - minMax[0]; i++) {
                List<List<Integer>> lists = map.get(minMax[0] + i);
                List<Integer> total = new ArrayList<>();
                for (int j = 0; j < lists.size(); j++) {
                    Collections.sort(lists.get(j));
                    total.addAll(lists.get(j));
                }
                list.add(total);
            }

            return list;
        }

        private void processOn(TreeNode root, Map<Integer,
                List<List<Integer>>> map, int x, int y, int[] minMax) {
            if (root == null) return;
            map.putIfAbsent(x, new ArrayList<>());

            while (map.get(x).size() <= y) {
                map.get(x).add(new ArrayList<>());
            }
            map.get(x).get(y).add(root.val);

            if (minMax[0] > x) {
                minMax[0] = x;
            }
            if (minMax[1] < x) {
                minMax[1] = x;
            }

            processOn(root.left, map, x - 1, y + 1, minMax);
            processOn(root.right, map, x + 1, y + 1, minMax);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
