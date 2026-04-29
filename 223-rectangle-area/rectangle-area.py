class Solution:
    def computeArea(self, ax1, ay1, ax2, ay2,
                          bx1, by1, bx2, by2):

        # Area of both rectangles
        area1 = (ax2 - ax1) * (ay2 - ay1)
        area2 = (bx2 - bx1) * (by2 - by1)

        # Overlap dimensions
        overlap_width = min(ax2, bx2) - max(ax1, bx1)
        overlap_height = min(ay2, by2) - max(ay1, by1)

        overlap = 0
        if overlap_width > 0 and overlap_height > 0:
            overlap = overlap_width * overlap_height

        return area1 + area2 - overlap