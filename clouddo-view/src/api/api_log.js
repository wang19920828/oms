import * as API from './'

export default {
  list: params => {
    return API.GET('/api-admin/log', params)
  },
  remove: params => {
    return API.DELETE('/api-admin/log', params)
  }
}
