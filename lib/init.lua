-- java-resource-azure-blob-library main module.
-- Renders Azure Blob Storage Spring configuration into the server module.
--
-- The calling archetype adds com.azure:azure-storage-blob dependency
-- to server pom.xml.
--
-- API:
--   local azure = require("java-resource-azure-blob")
--   azure.render(context, { destination = context:get("project-name") })

local M = {}

function M.render(context, opts)
    opts = opts or {}
    local d = opts.destination
    if d and d ~= "" then
        directory.render("contents", context, { destination = d })
    else
        directory.render("contents", context)
    end
    return context
end

return M
