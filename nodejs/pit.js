
function getDecreasing(a, p) {
	let q = p ;
	while (q + 1 < a.length && a[q + 1] < a[q]) {
		q = q + 1;
	} 	   
	return q;
}

function getIncreasing(a, q) {
	let r = q;
	while (r + 1 < a.length && a[r + 1] > a[r]) {
		r = r + 1;
	} 	   
	return r;
}

function maxd(a) {
	let p = 0;
	let q = -1;
	let r = -1;
	let maxDepth = -1;
	while (p < a.length) {
		// go until decreese
		let q = getDecreasing(a, p)
			if (p < q ) {
				let r = getIncreasing(a, q)
					if (r > q) {
						maxDepth = Math.min(a[p] - a[q], a[r] - a[q])  
							p = r;
					} else {
						p = q;
					}	
			} else {
				p = p + 1;
			}

	}
	return maxDepth;
}

let a = [10,4, 5, 7, 6, 5,4, 20]

console.log(maxd(a))
