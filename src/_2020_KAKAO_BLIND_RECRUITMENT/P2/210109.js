function solution(p) {
    return alg(p);
}

function alg(w) {
    if (w.length === 0) return '';
    const { u, v } = makeUV(w);
    if (checkValid(u)) {
        return u + alg(v);
    } else {
        let new_u = '';
        for (let i = 1; i < u.length-1; i++) {
            if (u.charAt(i) === '(') new_u += ')';
            else if (u.charAt(i) === ')') new_u += '(';
        }
        return '(' + alg(v) + ')' + new_u;
    }
}

function makeUV(s) {
    let u = '', v = '';
    let left = 0, right = 0, i;
    for (i = 0; i < s.length; i++) {
        if (s.charAt(i) === '(') left ++;
        else if (s.charAt(i) === ')') right ++;
        if (left === right) break;
    }
    u = s.substring(0, i+1);
    v = s.substring(i+1, s.length);
    return { u, v };
}

function checkValid(s) {
    let arr = [];
    for (let i = 0; i < s.length; i++) {
        let c = s.charAt(i);
        if (c === '(') arr.push(c);
        else if (c === ')') {
            if (arr.length > 0 && arr[arr.length-1] === '(') arr.pop();
            else return false;
        }
    }
    return arr.length === 0;
}