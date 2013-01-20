package pmpweb

class DateTagLib {
    
    static namespace ="pmp"
    
    def thisYear = {
        out << Calendar.getInstance().get(Calendar.YEAR)
    }
    
    def copyright ={ attrs, body ->
        out << "&copy; ${attrs['startYear']} - ${thisYear()}, ${body()}"
        out << " All Rights Reserverd."
    }

}
