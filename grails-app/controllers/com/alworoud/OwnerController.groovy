package com.alworoud

import org.springframework.dao.DataIntegrityViolationException
import org.grails.plugin.easygrid.Easygrid

@Easygrid
class OwnerController {

    //def index() { }    
    static grids = {
        ownerGrid {
            dataSourceType 'domain'
            domainClass Owner
            gridImpl 'jqgrid'
            jqgrid {
                width '"750"'
            }
            columns {
                id {
                    type 'id'
                }
                name {
                    filterClosure {params ->
                        ilike('name', "%${params.name}%")
                    }
                    jqgrid {
                        editable false
                        // this will create a link to the wikipedia page
                        //formatter 'customWikiFormat'
                    }
                }
                idNum {
                    filterClosure {params ->
                        ilike('idNum', "%${params.idNum}%")
                    }
                    jqgrid {
                        editable true
                    }
                }
            }
        }
    }
    
    def grid(){}
    static scaffold = true
}
