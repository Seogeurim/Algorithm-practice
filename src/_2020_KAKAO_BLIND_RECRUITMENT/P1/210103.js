function solution(s) {
    let min = 1001;
    for (let i = 1; i <= s.length; i++) {
        const comp_length = compStr(i, s);
        if (min > comp_length) min = comp_length
    }
    return min;
}

function compStr(unit, s) {
    let result = "";
    let old = "", count = 1;
    for (let i = 0; i < s.length; i += unit) {
        let target = s.substr(i, unit);
        if (old === target) {
            count ++;
        } else {
            if (count > 1) result += count + old;
            else result += old;
            count = 1;
        }
        old = target;
    }
    if (count > 1) result += count + old;
    else result += old;

    return result.length;
}
