package com.alworoud

import org.grails.plugin.easygrid.Easygrid

@Easygrid
class UnitController {

    static grids = {
        unitGrid {
            dataSourceType 'domain'
            domainClass Unit
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
                unitType {
                    filterClosure {params ->
                        ilike('unitType', "%${params.unitType}%")
                    }
                    jqgrid {
                        editable false
                    }
                }
                desc{
                    filterClosure{params ->
                        ilike('desc',"%${params.desc}%")
                    }    
                }
                status {
                    filterClosure {params ->
                        ilike('status', "%${params.status}%")
                    }
                }
                remarks {
                    filterClosure {params ->
                        ilike('remarks', "%${params.remarks}%")
                    }
                }
            }
        }
    }
    
    def grid(){}
    static scaffold = true
}
