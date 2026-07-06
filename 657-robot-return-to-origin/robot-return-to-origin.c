bool judgeCircle(char* moves) {

    char ch = 0;
    int i = 0;
    int x = 0;
    int y = 0;


    for(i=0; moves[i] != '\0'; i++){
        ch = moves[i];
        switch(ch){
            case 'U':
                y++;
            break;
            case 'D':
                y--;
            break;
            case 'R':
                x++;
            break;
            case 'L':
                x--;
            break;

            default:
                return false;

        }
    }

  return x == 0 && y == 0;
}