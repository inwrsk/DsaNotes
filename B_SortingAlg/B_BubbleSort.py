#from the first element move till last element and on the way compare the adjacent numbers and swap so that extreme value get's to the last
#and if we are placing the largest element in it's place then in the second iteration we will go from first pos to last-1 position as last postion is already sorted in iteration 1
def bubbleSort(arr):
    for i in range(len(arr)-1):
        for j in range(len(arr)-i-1):
            if arr[j]>arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]
arr = [3, 1, 4, 4, 8, 6]
print("Before sorting : ", arr)
bubbleSort(arr)
print("After sorting : ", arr)
