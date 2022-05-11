unsigned long long square_digits (unsigned n)
{
    unsigned long long q = 0;
    unsigned long long m = 1;
    unsigned r;
    do {
        r = n % 10;
        q += r * r * m;
        m *= r > 3 ? 100 : 10;
    } while(n /= 10);
    return q;
}