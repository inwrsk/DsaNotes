#Select smallest or biggest element in the array and place it in the begining or ending of the array.
#do it till the array is sorted
def selectionSort(arr):
    for i in range(len(arr)):
        minIndex = i
        for j in range(i+1,len(arr)):
            if arr[minIndex] > arr[j]:
                minIndex = j
        arr[minIndex],arr[i] = arr[i],arr[minIndex]
arr = [3, 1, 4, 4, 8, 6]
print("Before sorting : ", arr)
selectionSort(arr)
print("After sorting : ", arr)
