import * as API from './'

export default {
  list: params => {
    return API.GET('/api-admin/dept/list', params)
  },
  addDept:params =>{
    return API.GET('/api-admin/dept/save',params)
  },
  remove:params =>{
    return API.DELETE('/api-admin/dept/remove',params)
  }
}
