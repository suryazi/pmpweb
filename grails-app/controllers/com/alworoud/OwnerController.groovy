package com.alworoud

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
                    filterClosure {params ->
                        def val=params.id,op
                        if (val.length() > 2){
                            op=params.id[1]
                            if (op == '='){
                                val=params.id[2..-1]
                                op=params.id[0]
                                if (op == '<'){
                                    le('id',"${val}".toLong())
                                }else if (op == '>'){
                                    ge('id',"${val}".toLong())
                                }
                            }
                        } else if (params.id.length() > 1) {
                            val=params.id[1..-1]
                            op=params.id[0]
                            if (op == '<'){
                                lt('id',"${val}".toLong())
                            }else if (op == '>'){
                                gt('id',"${val}".toLong())
                            }else if (op == '='){
                                eq('id',"${val}".toLong())
                            }
                        }
                    }
                    jqgrid{
                        formatter 'linkId'
                    }   
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
