// Array Slicing Script

function sliceArray(arr, start, end) {
    return arr.slice(start, end);
}

let originalArray = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];

console.log("Original array:", originalArray);

let slicedArray1 = sliceArray(originalArray, 3, 7);
console.log("Sliced array (3 to 7):", slicedArray1);

let slicedArray2 = sliceArray(originalArray, 5);
console.log("Sliced array (5 to end):", slicedArray2);

let slicedArray3 = sliceArray(originalArray, 0, 4);
console.log("Sliced array (start to 4):", slicedArray3);

let slicedArray4 = sliceArray(originalArray, -3);
console.log("Sliced array (last 3 elements):", slicedArray4);

console.log("Original array after slicing:", originalArray);
