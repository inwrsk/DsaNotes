# we assume the first element is sorted and the remaining are unsorted
# take one element form unsorted at a time and place correctly in the sorted part (insertion)
# do this till you placed all the elements in the unsorted array.
def insertionSort(arr):
    for i in range(1,len(arr)):
        elemPos = i
        for j in range(i-1, -1, -1):
            if arr[j]>arr[elemPos]:
                arr[j], arr[elemPos] = arr[elemPos], arr[j]
                elemPos = j
            else:break
arr = [3, 1, 4, 4, 8, 6]
print("Before sorting : ", arr)
insertionSort(arr)
print("After sorting : ", arr)
